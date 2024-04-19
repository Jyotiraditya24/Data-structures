package BitWise_NumberSystem;

public class nthmagicnumberr {
    public static void main(String[] args) {
        System.out.println(magicNumber(3));
    }

    public static  int magicNumber(int num){
        int i = 1;
        int answer = 0;
        while(num>0){
            int numberMultiply = num & 1;
            answer = answer + numberMultiply * (int)Math.pow(5,i);
            i++;
            num = num >> 1;
        }
        return  answer;
    }
}
