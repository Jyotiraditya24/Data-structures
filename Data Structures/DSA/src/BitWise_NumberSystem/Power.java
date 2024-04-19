package BitWise_NumberSystem;

public class Power {
    public static void main(String[] args) {
        int ans = 1;
        int base = 3;
        int power = 6;

        while(power>0){
            if((power&1)==1){
                ans*=base;
            }
            base*=base;
            power = power>>1;
        }
    }
}
