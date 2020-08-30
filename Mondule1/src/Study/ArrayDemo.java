package Study;


public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = new int[10];  //动态创建
        int[] nums2 = {1,2,3,4,5}; //静态创建
        nums[1] = 2;
        System.out.println(nums.length);
        System.out.println(nums2.length);
        System.out.println(test()[0]);

    }

    public static String[] test(){
        return new String[]{"111"};
    }
}

