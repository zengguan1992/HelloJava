package Study;

import java.util.Scanner;

public class CalculateDemo {
    public static void main(String[] args) {
        System.out.println("This is a simple calculate");
        Scanner scanner = new Scanner(System.in);
        System.out.println("按q建退出");
        if(scanner.hasNextInt()){

        }
    }

    public int addition(int a,int b){
        return a+b;
    }

    public int substitution(int a, int b){
        return a-b;
    }

    public int multiplication(int a,int b){
        return a*b;
    }

    public int division(int a,int b){
        return a/b;
    }
}
