package com.qjx.dp.isp.controller;

import com.qjx.dp.isp.service.AbstractSearcher;
import com.qjx.dp.isp.service.IGoodBodyGirl;
import com.qjx.dp.isp.service.IGreatTemperamentGirl;
import com.qjx.dp.isp.service.impl.PettyGirl;
import com.qjx.dp.isp.service.impl.Searcher;

/**
 * @author: qincasin
 * @date: 2019/8/9/ 18:13
 */
public class Client {

  public static void main(String[] args) {
    IGreatTemperamentGirl greatTemperamentGirl = new PettyGirl("嫣嫣");
    IGoodBodyGirl goodBodyGirl = new PettyGirl("火火");
    AbstractSearcher searcher = new Searcher(goodBodyGirl);
    searcher.show();

    AbstractSearcher searcher1 = new Searcher(goodBodyGirl);
    searcher1.show();

  }

}
