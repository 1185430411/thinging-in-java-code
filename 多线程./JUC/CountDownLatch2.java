package com.jay.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class safe implements Runnable {
    static CountDownLatch latch=new CountDownLatch(10);
    static CountDownLatch main=new CountDownLatch(1);
    static safe demo=new safe();
    @Override
    public void run() {
        try {
        	main.await();
            System.out.println("等待线程执行完成!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        	//latch计数-1
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            exec.submit(demo);
        }
        System.out.println("主线程首先执行");
        System.out.println("主线程执行完毕,开始执行等待线程");
        //-1
        main.countDown();
        //等待其他线程完成操作
        latch.await();
        System.out.println("全部执行完成");
        exec.shutdown();
    }
}


