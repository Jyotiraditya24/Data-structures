package MathforDsa;

public class Factor {
    public static void main(String[] args) {
        factors(25);
    }
    public static void factors(int n){
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                if(i == n/i){
                    System.out.print(" "+i+" ");
                }else {
                    System.out.print(" "+i+" "+n/i);
                }
            }
        }
    }
}

