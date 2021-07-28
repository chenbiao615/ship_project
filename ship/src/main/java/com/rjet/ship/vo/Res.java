package com.rjet.ship.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: 项目名
 * @description: 描述
 * @author: libowen
 * @create: 2021-07-27 11:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {

    private List<ResData> data;

    private String status;
}
