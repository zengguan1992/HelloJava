package com.zg.study.Thread;

import java.util.concurrent.*;

/*
    Callable的好处：
    1.可以定义返回值
    2.可以抛出异常
*/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable(999);
        //1.创建执行服务,开启线程池
        ExecutorService service = Executors.newFixedThreadPool(1);
        //2.提交执行
        Future<Integer> result = service.submit(myCallable);
        //3.获取结果
        int res = result.get();
        System.out.println(res);
        //4.关闭服务
        service.shutdown();
    }


}

class MyCallable implements Callable<Integer>{
    private Integer num;
    public MyCallable(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        return this.num;
    }
}