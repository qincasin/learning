package com.qjx.dp.dip.service.impl;

import com.qjx.dp.dip.service.ICar;

/**
 * @author: qincasin
 * @date: 2019/8/8/ 18:15
 */
public class Benz implements ICar {

  @Override
  public void run() {
    System.out.println("奔驰汽车开始运作了....");
  }
}
