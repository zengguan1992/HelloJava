package com.zg.study.Thread;

/*  推荐使用
    通过实现Runnable接口开启线程，相对于继承Thread类的话可以避免JAVA OOP单继承的局限性
    *方便同一个对象被多个线程使用*

    1.自定义线程类实现(implements)Runnable接口
    2.重写Run方法，编写线程执行体
    3.创建自定义类的对象，new一个线程，把自定义类对象传进去，调用start方法

 */

public class RunnableDemo {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        //Thread thread = new Thread(myRunnable);
        //thread.start();
        new Thread(myRunnable,"zg").start(); //等价于上两句代码

    }
}

class MyRunnable implements Runnable{

    //private String name;

    //MyRunnable(String name){
    //    this.name = name;
    //}

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println(this.name+"正在学习中..."+i);
            System.out.println(Thread.currentThread().getName()+"正在学习中..."+i);
        }
    }
}