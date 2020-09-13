package com.zg.study.Thread.Synchronized;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"you");
        Drawing yourGirlfriend = new Drawing(account,100,"yourGirlfriend");

        new Thread(you).start();
        new Thread(yourGirlfriend).start();
    }
}

//账户类
class Account{
    int money;
    String type;
    public Account(int money, String type) {
        this.money = money;
        this.type = type;
    }
}

//银行：模拟取款
class Drawing implements Runnable{

    Account account; //账户
    int drawingMoney;//取了多少钱
    int nowMoney;//现在手里有多少钱
    String name;

    public Drawing(Account account,int drawingMoney,String name) {
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            drawMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void drawMoney() throws InterruptedException {

        synchronized (account){
            if(account.money - drawingMoney <0){
                //System.out.println(Thread.currentThread().getName()+"钱不够了，取不了");
                System.out.println(account.type+"钱不够了,"+name+"取不了");
                return;
            }
            Thread.sleep(100);
            account.money = account.money - drawingMoney;//卡内余额 = 卡内余额 - 你取的钱
            nowMoney = nowMoney + drawingMoney;//你手里的钱 = 现在手里有的钱 + 你取的钱
            System.out.println(name+"取走了"+drawingMoney+","+account.type+"余额为"+account.money);
            //System.out.println(Thread.currentThread().getName()+"手里的钱为"+nowMoney);
            System.out.println(name+"手里的钱为"+nowMoney);
        }

    }
}
