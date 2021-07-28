package com.rjet.ship.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: 项目名
 * @description: 描述
 * @author: libowen
 * @create: 2021-07-27 13:19
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDetail {


    @ApiModelProperty(value = "mmsi")
    private String mmsi;

    @ApiModelProperty(value = "呼号")
    private String callSign;

    @ApiModelProperty(value = "imo")
    private String imo;

    @ApiModelProperty(value = "类型")
    private String shipType;


    @ApiModelProperty(value = "经度")
    private String lon;

    @ApiModelProperty(value = "纬度")
    private String lat;

    @ApiModelProperty(value = "目的地")
    private String dest;

    @ApiModelProperty(value = "航速")
    private String sog;

    @ApiModelProperty(value = "状态")
    private String navistat;






}
