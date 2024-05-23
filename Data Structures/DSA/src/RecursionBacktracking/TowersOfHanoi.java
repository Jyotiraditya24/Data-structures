package RecursionBacktracking;

public class TowersOfHanoi {
    public static void main(String[] args) {
        toh(4,"A","B","C");
    }

    public static void toh(int n,String TowerA,String TowerB, String TowerC){
        if(n == 0){
            return;
        }
        toh(n-1,TowerA,TowerC,TowerB); // will  print the instructions to move n-1 disks from t1 to t3 using t2
        System.out.println(n+"["+TowerA + " -> "+ TowerB+ "]");
        toh(n-1,TowerC,TowerB,TowerA);// will  print the instructions to move n-1 disks from t3 to t2 using t1

    }
}
