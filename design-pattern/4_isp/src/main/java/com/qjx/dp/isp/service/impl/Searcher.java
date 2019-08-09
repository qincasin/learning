package com.qjx.dp.isp.service.impl;

import com.qjx.dp.isp.service.AbstractSearcher;
import com.qjx.dp.isp.service.IGoodBodyGirl;
import com.qjx.dp.isp.service.IGreatTemperamentGirl;

/**
 * @author: qincasin
 * @date: 2019/8/9/ 18:21
 */
public class Searcher extends AbstractSearcher {

  public Searcher(IGoodBodyGirl goodBodyGirl) {
    super(goodBodyGirl);
  }

  public Searcher(IGreatTemperamentGirl greatTemperamentGirl) {
    super(greatTemperamentGirl);
  }

  @Override
  public void show() {
    System.out.println("美女信息如下:............");
    super.goodBodyGirl.goodLooking();
    super.goodBodyGirl.niceFigure();
//    super.greatTemperamentGirl.greatTemperament();
  }
}
