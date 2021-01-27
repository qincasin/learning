package com.qjx.java.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qincasin on 2021/1/26.
 */
public class TestApi {

    @Test
    public void test_128hash(){
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("小傅哥");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        new HashMap<>()

        String[] tab = new String[8];
        for (String key : list) {
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key值=%s Idx=%d,hashCode=%d",key,idx,key.hashCode()));
            if(tab[idx]==null){
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx]+"->"+key;

        }
        System.out.println(JSON.toJSONString(tab));

    }

}
