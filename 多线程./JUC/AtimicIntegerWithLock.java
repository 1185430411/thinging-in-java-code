package com.jay.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicIntegerWithLock {
    private int value;
    private Lock lock=new ReentrantLock();

    public AtomicIntegerWithLock(){
        super();
    }
    public AtomicIntegerWithLock(int value){
        this.value=value;
    }

    /*
    * get方法
    * */
    public final int get(){
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }
    /*
    * set方法
    * */
    public final void set(int newValue){
        lock.lock();
        try {
            value=newValue;
        }finally {
            lock.unlock();
        }
    }

    /*
    * 获取当前值之后，设置新值
    * */
    public final int getAndSet(int newValue){
        lock.lock();
        try {
            int cache=value;
            value=newValue;
            return cache;
        }finally {
            lock.unlock();
        }
    }

    /*
    * 若与预期值相同，则设为新值，返回true
    * 否则返回false，值不作修改
    * */
    public final boolean compareAndSet(int expect,int newValue){
        lock.lock();
        try {
            if(value==expect){
                value=newValue;
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }

    /*
    * 获取当前值，然后自增
    * */
    public final int getAndIncrement(){
        lock.lock();
        try {
            return value++;
        }finally {
            lock.unlock();
        }
    }

    /*
    * 获取当前值之后，自减
    * */
    public final int getAndDecrement() {
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }

    /*
    * 自增后获取值
    * */
    public final int incrementAndGet() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    /*
     *自减后获取值
     */
    public final int decrementAndGet() {
        lock.lock();
        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return Integer.toString(get());
    }
}
