package com.qjx.dp.dip.service.impl;

import com.qjx.dp.dip.service.ICar;
import com.qjx.dp.dip.service.IDriver;

/**
 * @author: qincasin
 * @date: 2019/8/8/ 18:13
 */
public class Driver implements IDriver {
  //司机的职责就是驾驶汽车
  @Override
  public void driver(ICar car) {
    car.run();
  }
}
