/*
int addAndGet(int delta)
          以原子方式将给定值与当前值相加。 实际上就是等于线程安全版本的i =i+delta操作。

boolean compareAndSet(int expect, int update)
          如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。 如果成功就返回true，否则返回false，并且不修改原值。

int decrementAndGet()
          以原子方式将当前值减 1。 相当于线程安全版本的--i操作。

int get()
          获取当前值。

int getAndAdd(int delta)
          以原子方式将给定值与当前值相加。 相当于线程安全版本的t=i;i+=delta;return t;操作。

int getAndDecrement()
          以原子方式将当前值减 1。 相当于线程安全版本的i--操作。

int getAndIncrement()
          以原子方式将当前值加 1。 相当于线程安全版本的i++操作。

int getAndSet(int newValue)
          以原子方式设置为给定值，并返回旧值。 相当于线程安全版本的t=i;i=newValue;return t;操作。

int incrementAndGet()
          以原子方式将当前值加 1。 相当于线程安全版本的++i操作。 

void lazySet(int newValue)
          最后设置为给定值。 延时设置变量值，这个等价于set()方法，但是由于字段是volatile类型的，因此次字段的修改会比普通字段（非volatile字段）有稍微的性能延时（尽管可以忽略），所以如果不是想立即读取设置的新值，允许在“后台”修改值，那么此方法就很有用。如果还是难以理解，这里就类似于启动一个后台线程如执行修改新值的任务，原线程就不等待修改结果立即返回（这种解释其实是不正确的，但是可以这么理解）。

void set(int newValue)
          设置为给定值。 直接修改原始值，也就是i=newValue操作。

boolean weakCompareAndSet(int expect, int update)
          如果当前值 == 预期值，则以原子方式将该设置为给定的更新值。JSR规范中说：以原子方式读取和有条件地写入变量但不 创建任何 happen-before 排序，因此不提供与除 weakCompareAndSet 目标外任何变量以前或后续读取或写入操作有关的任何保证。大意就是说调用weakCompareAndSet时并不能保证不存在happen-before的发生（也就是可能存在指令重排序导致此操作失败）。但是从Java源码来看，其实此方法并没有实现JSR规范的要求，最后效果和compareAndSet是等效的，都调用了unsafe.compareAndSwapInt()完成操作。
*/

package com.jay.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class juc {
    public static void main(String[] args)throws InterruptedException{
        final AtomicInteger val=new AtomicInteger(0);
        final int ThreadSize=10;
        Thread[] t=new Thread[ThreadSize];
        for(int i=0;i<ThreadSize;i++){
            t[i]=new Thread(){
                public void run(){
                    val.incrementAndGet();
                }
            };
        }

        for(Thread nowT:t){
            nowT.start();
        }
        for(Thread nowT:t){
            nowT.join();
        }
        System.out.println(val.compareAndSet(10,2));
        System.out.println(val.compareAndSet(2,3));

    }

}
