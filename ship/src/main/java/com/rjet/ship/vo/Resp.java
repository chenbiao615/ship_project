package com.rjet.ship.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: 项目名
 * @description: 描述
 * @author: libowen
 * @create: 2021-07-27 14:32
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resp {


    private List<ResDetail> data;

    private String status;
}
