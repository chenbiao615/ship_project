package com.rjet.ship.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rjet.ship.vo.Res;

import com.rjet.ship.vo.Resp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.transform.Scale;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: 项目名
 * @description: 描述
 * @author: libowen
 * @create: 2021-07-27 08:45
 **/
@Api(tags = "船舶")
@CrossOrigin
@RestController
@RequestMapping("/ship")
public class QueryController {


    @ApiOperation("关键字查询船舶Id")
    @GetMapping("/query/{keyWord}")
    public Res  queryShip(@PathVariable String keyWord){


      String idApiUrl=  String.format("http://api.shipxy.com/apicall/QueryShip?k=89f9e23ce77e4882a3e0986ff6a33088&enc=1&kw="+keyWord+"&max=3");

      String shipStr= HttpUtil.get(idApiUrl);

        Res res = JSON.parseObject(shipStr, Res.class);

        if (res.getData().size() <= 0){
            return null;
        }

       return res;

//        String shipApiUrl =String.format("http://api.shipxy.com/apicall/GetSingleShip?k=89f9e23ce77e4882a3e0986ff6a33088&enc=1&id="+shipId);
//
//        String shipStr2=  HttpUtil.get(shipApiUrl);
//
//        JSONObject shipJson = JSONObject.parseObject(shipStr2);
//
//
//        return shipJson;
    }

    @ApiOperation("通过id查询船舶信息")
    @GetMapping("/detail/{shipId}")

    public Resp shipDetail(@PathVariable String shipId){

        String shipApiUrl =String.format("http://api.shipxy.com/apicall/GetSingleShip?k=89f9e23ce77e4882a3e0986ff6a33088&enc=1&id="+shipId);


        String shipStr=  HttpUtil.get(shipApiUrl);


       Resp resp =  JSONObject.parseObject(shipStr, Resp.class);


        if (resp.getData().size() <= 0){
            return null;
        }

        String sog=  resp.getData().get(0).getSog();

        BigDecimal speed=new BigDecimal(sog);

        BigDecimal speed2=  speed.divide(new BigDecimal(514.444),2,BigDecimal.ROUND_DOWN);

        resp.getData().get(0).setSog(speed2.toString());


        String status = resp.getData().get(0).getNavistat();


        if (ObjectUtil.equal(status,"0")){
            resp.getData().get(0).setNavistat("在航（主机推动）");

        }
        if (ObjectUtil.equal(status,"5")){
            resp.getData().get(0).setNavistat("靠泊");
        }
        if (ObjectUtil.equal(status,"1")){
            resp.getData().get(0).setNavistat("锚泊");
        }
        if (ObjectUtil.equal(status,"2")){
            resp.getData().get(0).setNavistat("失控");
        }
        if (ObjectUtil.equal(status,"3")){
            resp.getData().get(0).setNavistat("操纵受限");
        }
        if (ObjectUtil.equal(status,"4")){
            resp.getData().get(0).setNavistat("吃水受限");
        }
        if (ObjectUtil.equal(status,"6")){
            resp.getData().get(0).setNavistat("搁浅");
        }
        if (ObjectUtil.equal(status,"7")){
            resp.getData().get(0).setNavistat("捕捞作业");
        }
        if (ObjectUtil.equal(status,"8")){
            resp.getData().get(0).setNavistat("靠帆船提供动力");
        }
        if (ObjectUtil.equal(status,"9")){
            resp.getData().get(0).setNavistat("为将来 HSC 航行状态修正保留");
        }
        if (ObjectUtil.equal(status,"10")){
            resp.getData().get(0).setNavistat("为将来 WIG 航行状态修正保留");
        }else {

            resp.getData().get(0).setNavistat("未定义该状态");
        }



        return resp;


    }





}
