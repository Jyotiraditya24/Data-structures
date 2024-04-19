package BitWise_NumberSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]arr = {2,2,4,2};
        System.out.println(singleNumber(arr));
    }
        public static int singleNumber(int[] nums) {
            int ans = 0;
            for(int i=0;i<32;i++){
                int sum = 0;
                for(int j=0;j<nums.length;j++){
                    sum = sum + ((nums[j] >> i) & 1);
                }
                sum=sum%3;
                ans |= (sum << i);
            }
            return ans;
        }
}
