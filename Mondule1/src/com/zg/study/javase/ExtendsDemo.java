package com.zg.study.javase;


public class ExtendsDemo {

    public static void main(String[] args) {
        //Student student = new Student();
        //student.Say();

        Teacher teacher = new Teacher();
        teacher.test("God");



    }

}


/********************父类***************************/
class Person{

    protected String name = "zg";

    public void Say(){
        System.out.println("Person: Hello");
    }
}

/********************派生类，子类***************************/
class Student extends Person{

    @Override
    public void Say() {
        System.out.println("Student: Hello");
    }
}

/*****************派生类，子类******************************/
class Teacher extends Person{

    private String name = "teacher_zg";
    public void test(String name){
        System.out.println("name:"+name);
        System.out.println("thisName:"+this.name);
        System.out.println("superName:"+super.name);
    }



}