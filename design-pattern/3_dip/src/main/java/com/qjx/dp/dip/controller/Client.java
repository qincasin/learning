package com.qjx.dp.dip.controller;

import com.qjx.dp.dip.service.ICar;
import com.qjx.dp.dip.service.IDriver;
import com.qjx.dp.dip.service.impl.Benz;
import com.qjx.dp.dip.service.impl.Driver;

/**
 * @author: qincasin
 * @date: 2019/8/8/ 18:17
 */
public class Client {

  public static void main(String[] args) {
    IDriver zhangsan = new Driver();
    ICar benz = new Benz();
    zhangsan.driver(benz);
  }

}
