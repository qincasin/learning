package com.qjx.concurrency.example.syncContainer;

import com.qjx.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * Vector 等集合 遍历时进行同时进行remove操作会出现java.util.ConcurrentModificationException 异常
 * 如果想进行遍历时remove操作，建议使用for循环
 * 建议不使用这样的操作，建议循环结束后在进行remove操作。
 *
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {
    /**
     * foreach
     * 报:java.util.ConcurrentModificationException
     * @param v1
     */
    private static void test1(Vector<Integer> v1){

        for(Integer i:v1){
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    /**
     * Iterator
     * 报:java.util.ConcurrentModificationException
     * @param v2
     */
    private static void test2(Vector<Integer> v2){
        Iterator<Integer> iterator = v2.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                v2.remove(i);
            }
        }
    }

    /**
     * for
     * 正常
     * @param v3
     */
    private static void test3(Vector<Integer> v3){
        for (int i = 0; i < v3.size(); i++) {
            if(v3.get(i).equals(3)){
                v3.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }

}
