package com.qjx.dp.isp.service;

/**
 * @author: qincasin
 * @date: 2019/8/9/ 17:51
 */
public abstract class AbstractSearcher {

  protected IGoodBodyGirl goodBodyGirl;
  protected IGreatTemperamentGirl greatTemperamentGirl;

  public AbstractSearcher(IGoodBodyGirl goodBodyGirl) {
    this.goodBodyGirl = goodBodyGirl;
  }

  public AbstractSearcher(IGreatTemperamentGirl greatTemperamentGirl) {
    this.greatTemperamentGirl = greatTemperamentGirl;
  }

  /**
   * 搜索美女 列出美女信息
   */
  public abstract void show();
}
