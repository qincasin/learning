package com.qjx.concurrency.example.threadlocal;

public class RequestHolder {

    private static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    /**
     * 存数据
     * @param id
     */
    public static void add(Long id){
        requestHolder.set(id);
    }

    /**
     * 获取数据
     * @return
     */
    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 移除数据
     */
    public static void remove(){
        requestHolder.remove();
    }



}
