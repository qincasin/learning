package com.qjx.dp.isp.service.impl;

import com.qjx.dp.isp.service.IGoodBodyGirl;
import com.qjx.dp.isp.service.IGreatTemperamentGirl;

/**
 * @author: qincasin
 * @date: 2019/8/9/ 18:02
 */
public class PettyGirl implements IGoodBodyGirl, IGreatTemperamentGirl {

  private String name;

  public PettyGirl(String name) {
    this.name = name;
  }

  @Override
  public void goodLooking() {
    System.out.println(name + "-----脸蛋很漂亮");

  }

  @Override
  public void niceFigure() {
    System.out.println(name + "-----身材非常棒");
  }

  @Override
  public void greatTemperament() {
    System.out.println(name + "----气质非常好");
  }
}
