package com.jay.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class safe{


    public static void main(String[] args){
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        // 一个线程进行写
        new Thread(new Runnable(){
            public void run(){
                rw.write((int)(Math.random()*100));
            }
        },"Write:").start();

        // 100个线程进行读操作
        for(int i=0; i<100; i++){
            new Thread(new Runnable(){
                public void run(){
                    rw.read();
                }
            },"Read:").start();
        }
    }

}

class ReadWriteLockDemo{
	private int num=0;
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	
	//读操作
	public void read() {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+":"+num);
		}finally {
			lock.readLock().unlock();
		}
	}
	
	//写操作
	public void write(int num) {
		lock.writeLock().lock();
		try {
			System.out.println("Write:");
			this.num=num;
		}finally {
			lock.writeLock().unlock();
		}
	}
}
