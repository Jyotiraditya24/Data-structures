package DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
        int val = 20;
        int[]arr = new int[val+1];
        for (int i = 0; i <= val; i++) {
            arr[i] = -1;
        }
        int result = DpFibonacci(val,arr);
        System.out.println(result);
    }

    public static int DpFibonacci(int val,int[]arr){
        if(val <= 1){
            return val;
        }

        if(arr[val]!=-1){
           return arr[val];
        }
        arr[val] = DpFibonacci(val - 1,arr ) + DpFibonacci(val-2,arr);
        return arr[val];
    }
}
