import Study.ExInterfaceDemo;

/**
 * @author zg
 * @version 1.0
 * @since 1.8
 */
public class test {
    public static void main(String[] args) {
        ExInterfaceDemo ex = new ExInterfaceDemo();
        String order = "1231";
        System.out.println(ex.queryOrder(order));

    }
    public static String test1(){

        return "Hello";
    }
}
