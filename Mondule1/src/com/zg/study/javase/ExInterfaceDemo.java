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
