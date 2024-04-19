package MathforDsa;

import java.util.Arrays;

public class Sieve {
    public static void main(String[] args) {
        int n = 10;
        boolean [] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        sieve(n,primes);
        for(int i=2;i<primes.length;i++){
            if(primes[i]){
                System.out.println(i);
            }
        }
    }
    static void sieve(int n,boolean[]primes){
        for(int i=2;i*i<=n;i++){
            if(primes[i]){
                for (int j = i*2;j <=n; j=j+i){
                    primes[j] = false;
                }
            }
        }
    }
}
