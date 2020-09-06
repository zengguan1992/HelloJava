package com.zg.study.javase;

import  java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        demo1();
        demo2();

    }

    /**
     * accept str before space
     * 接收到空格前的信息
     */
    public static void demo1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("使用next的方法接收：");
        String str = scanner.next();
        System.out.println("你输入的信息为：" + str);
        scanner.close();
    }



    /**
     * 接收回车前的信息
     * accept str before enter
     */
    public static void demo2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("使用nextLine方法接收：");
        String str = scanner.nextLine();
        System.out.println("你输入的信息为："+ str);
        scanner.close();
    }
}
