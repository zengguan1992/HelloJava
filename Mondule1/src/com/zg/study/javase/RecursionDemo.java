package com.zg.study.javase;

public class RecursionDemo {
    public static void main(String[] args) {
        RecursionDemo r = new RecursionDemo();
        int result = r.f(5);
        System.out.println(result);
    }

    /*
    * 阶乘的概念
    * 1！ 1
    * 2！ 2*1
    * 3！ 3*2*1
    * 4！ 4*3*2*1
    * 5！ 5*4*3*2*1
    */

    /**
     * 递归方法实现阶乘计算
     * @param n
     * @return int
     */
    public int f(int n){
        if(n == 1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }

}
