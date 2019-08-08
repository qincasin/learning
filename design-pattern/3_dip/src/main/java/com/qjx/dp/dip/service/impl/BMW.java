package com.qjx.dp.dip.service.impl;

import com.qjx.dp.dip.service.ICar;

/**
 * @author: qincasin
 * @date: 2019/8/8/ 18:15
 */
public class BMW implements ICar {

  @Override
  public void run() {
    System.out.println("BMW开始启动了....");
  }

}
