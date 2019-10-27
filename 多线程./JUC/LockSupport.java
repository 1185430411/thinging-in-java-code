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
	//添加volatile，使t2能够得到通知
		volatile List lists = new ArrayList();

		public void add(Object o) {
			lists.add(o);
		}

		public int size() {
			return lists.size();
		}
		
		static Thread t1 = null, t2 = null;
		
		public static void main(String[] args) {
			safe c = new safe();
			
			t1 = new Thread(() -> {
				System.out.println("t1启动");
				for (int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("add " + i);

					if (c.size() == 5) {
						LockSupport.unpark(t2);
						LockSupport.park();
					}
				}
			}, "t1");

			t2 = new Thread(() -> {
				//System.out.println("t2启动");
				//if (c.size() != 5) {

					LockSupport.park();

				//}
				System.out.println("t2 结束");
				LockSupport.unpark(t1);


			}, "t2");

			t2.start();
			t1.start();

			
		}
	}
