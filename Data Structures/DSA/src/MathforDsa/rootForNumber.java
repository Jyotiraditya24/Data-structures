package MathforDsa;

public class rootForNumber {
    public static void main(String[] args) {
        System.out.println(root(40,2));
    }

    public static double root(int n,int p){
        int start = 0;
        int end = n;
        double root = 0.0;
        while(start>end){
            int mid = (start+end)/2;
            if(mid*mid == n){
                root = mid;
                return mid;
            }else if(mid*mid>n){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        double inr = 0.1;
        for (int i=0;i<p;i++){
            while (root*root<=n){
                root+=inr;
            }
            root -= inr;
            inr/=10;
        }
        return root;
    }
}
