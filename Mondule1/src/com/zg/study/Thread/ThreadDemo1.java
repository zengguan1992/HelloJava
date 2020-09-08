package com.zg.study.Thread;


/*
    继承Thread类开启线程

    1.自定义线程类继承Thread类
    2.重写run方法，编写线程执行体，把线程要执行的操作写在run方法里
    3.创建线程对象，在主线程里用start开启新线程(如果是直接调用run方法的话，不会另外开线程，会按顺序执行主线程里的代码)

    线程不一定立即执行，CPU安排调度
 */


public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("zg");
        t1.start();
    }
}

class MyThread1 extends Thread{

    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name+"-执行线程中..."+i);
        }
    }
}



