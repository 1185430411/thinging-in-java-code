package com.jay.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class safe implements Runnable {
    static CountDownLatch latch=new CountDownLatch(10);
    static safe demo=new safe();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println("check complete");
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
        //主线程等待latch被归为0；在等待过程中，主线程堵塞
        latch.await();
        System.out.println("wait complete,go main");
        exec.shutdown();
    }
}


