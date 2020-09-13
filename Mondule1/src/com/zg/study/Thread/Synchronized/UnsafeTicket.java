package com.zg.study.Thread.Synchronized;


public class UnsafeTicket {
    public static void main(String[] args) {

        BuyTicket station = new BuyTicket();
        Thread buyTicket_T1 = new Thread(station,"学生");
        Thread buyTicket_T2 = new Thread(station,"黄牛");
        Thread buyTicket_T3 = new Thread(station,"社会人");
        buyTicket_T1.start();
        buyTicket_T2.start();
        buyTicket_T3.start();
    }
}

//实现Runnable接口的话方便同一个对象被多个线程调用
class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        buy();
    }

    //synchronized 不能在循环外
    private void buy(){
        while (flag){
            synchronized (this){
                if(ticketNums <=0){
                    flag = false;
                    return;
                }
                //模拟延时
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //买票
                System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
            }


        }
    }

}

//继承Thread类的话如果要传参数要再写一次构造方法
class BuyTicketThread extends Thread{
    private int ticketNums = 10;
    private boolean flag = true;

    //构造方法
    public BuyTicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        buy();
    }

    private void buy(){
        while (flag){
            if(ticketNums <=0){
                flag = false;
                return;
            }
            //买票
            System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
        }
    }
}
