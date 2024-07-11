package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
//        int val = 20;
//        int[]arr = new int[val+1];
//        for (int i = 0; i <= val; i++) {
//            arr[i] = -1;
//        }
//        int result = DpFibonacci(val,arr);
//        System.out.println(result);

//        for tabulation method
        int val = 10;
        int []arr = new int[val+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2;i<=val;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int DpFibonacci(int val,int[]arr) {
        if (val <= 1) {
            return val;
        }

        if (arr[val] != -1) {
            return arr[val];
        }
        arr[val] = DpFibonacci(val - 1, arr) + DpFibonacci(val - 2, arr);
        return arr[val];
    }
}
