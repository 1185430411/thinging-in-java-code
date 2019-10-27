package com.jay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class safe {
	private volatile static int sum=0;
	static Object lock=new Object();
	
	public static void main(String[] args) { 
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock) {
					for(int i=0;i<20;i++) {
						if(sum>=5) {
							try {
								//释放锁，优先让给别的线程拥有
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							sum++;
							System.out.println("生产"+sum);
							lock.notifyAll();
						}
					}
				}
			}
			
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock) {
					for(int i=0;i<20;i++) {
						if(sum<=0) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							System.out.println("消费"+sum);
							sum--;
							lock.notifyAll();
						}
					}
				}
			}
			
		}).start();
	}
}
