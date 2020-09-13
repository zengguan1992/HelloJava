package com.zg.study.Thread.ProductConsumer;

import javax.xml.transform.Source;

public class FlagDemo1 {
    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);
        new Thread(player).start();
        new Thread(watcher).start();
    }

}

//生产者-->演员
class Player implements Runnable{
    
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("快乐大本营");
            }
            else{
                this.tv.play("极限挑战");
            }
        }
    }
}

//消费者-->观众
class Watcher implements Runnable{

    TV tv;
    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

//产品-->节目
class TV{
    //演员表演，观众等待 T  ---->运行play().notifyAll()，阻断watch().wait()
    //观众观看，演员等待 F  ---->运行watch().notifyAll(),阻断play().wait()
    String voice; //表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了:"+voice);
        //通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了:"+voice);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}