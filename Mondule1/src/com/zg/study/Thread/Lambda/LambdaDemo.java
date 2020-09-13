package com.zg.study.Thread.Lambda;


/*
    Lambda表达式简化过程
 */
public class LambdaDemo {
    public static void main(String[] args) {

        //1的调用(定义实现类)
        Runnable studyLambda = new StudyLambda_outClass();  //定义一个接口对象，new一个实现类
        new Thread(studyLambda).start();

        //2的调用(静态内部类)
        studyLambda = new StudyLambda_staticInClass();
        new Thread(studyLambda).start();

        //3.局部内部类
        class StudyLambda_partClass implements Runnable{
            @Override
            public void run() {
                System.out.println("zg is studying lambda3");
            }
        }
        //3的调用(局部内部类)
        studyLambda = new StudyLambda_partClass();
        new Thread(studyLambda).start();


        //4.匿名内部类，不定义类名，直接new函数式接口
        studyLambda = new Runnable(){
            @Override
            public void run() {
                System.out.println("zg is studying lambda4");
            }
        };
        new Thread(studyLambda).start();


        //5.lambda表达式,在匿名内部类的基础上简化代码，去掉new接口名，方法名，保留方法()和方法体，用->合并
        //如果接口方法有参数，就写在()里
        studyLambda = ()->{
            System.out.println("zg is studying lambda5");
        };
        new Thread(studyLambda).start();

    }

    //2.静态内部类
    static class StudyLambda_staticInClass implements Runnable{
        @Override
        public void run() {
            System.out.println("zg is studying lambda2");
        }
    }

}

//Runnable是一个函数式接口
//1.定义实现类
class StudyLambda_outClass implements Runnable{
    @Override
    public void run() {
        System.out.println("zg is studying lambda1");
    }
}