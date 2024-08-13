package StriverGraph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for(int i = 0 ;i<=V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(8);
        adj.get(4).add(3);

        adj.get(5).add(2);

        adj.get(6).add(2);

        adj.get(7).add(3);
        adj.get(7).add(8);

        adj.get(8).add(4);
        adj.get(8).add(7);


        ArrayList<Integer> dfs =  DfsOfGraph(adj,V);
        System.out.println(dfs);
    }

    public static ArrayList<Integer> DfsOfGraph(ArrayList<ArrayList<Integer>> adj,int V){
        boolean[]visited = new boolean[V+1];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        st.push(1);
        visited[1] = true;

        while (!st.isEmpty()){
            int node = st.pop();
            ans.add(node);
            ArrayList<Integer> list =  adj.get(node);
            for(Integer i :list){
                if(!visited[i]){
                    st.push(i);
                    visited[i] = true;
                }
            }
        }
        return  ans;
    }

}
