package RecursionBacktracking;

public class PowerXN {
    public static void main(String[] args) {
        System.out.println(poXn(3,4));
    }

    public static int poXn(int x,int n){
        if(n == 1){
            return x;
        }

       return x*poXn(x,n-1);
    }
}
