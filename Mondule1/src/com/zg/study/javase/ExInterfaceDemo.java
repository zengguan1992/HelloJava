package com.zg.study.javase;

public class ExInterfaceDemo implements InterfaceDemo{
    @Override
    public int queryOrder(String orderNum) {
        if(orderNum.equals("123")){
            return 0;
        }else {
            return -1;
        }

    }

    @Override
    public int cancelOrder(String orderNum) {
        return 0;
    }
}

class InterfaceImp{
    public static void main(String[] args) {
        InterfaceDemo test = new ExInterfaceDemo(); //定义一个接口，new一个该接口实现类
        test.queryOrder("123123");
    }
}