package com.zg.study.Thread.ProductConsumer;

public class FlagDemo_eterm {
    public static void main(String[] args) {
        Eterm eterm = new Eterm();
        Issue issue = new Issue();
        Change change = new Change();
        Refund refund = new Refund();


    }
}

class Eterm{

    String user;
    boolean flag_issue = true;
    boolean flag_change = true;
    boolean flag_refund = true;

}

class Issue implements Runnable{

    @Override
    public void run() {
        System.out.println("操作出票");
    }
}

class Change implements Runnable{

    @Override
    public void run() {
        System.out.println("操作改签");
    }
}

class Refund implements Runnable{

    @Override
    public void run() {
        System.out.println("操作退票");
    }
}

