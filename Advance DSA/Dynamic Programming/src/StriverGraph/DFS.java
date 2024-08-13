package StriverGraph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[][]isConnected = {
                {0,0,0,0,0,0},
                {0,0,1,0,0,1},
                {0,1,0,1,1,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,1},
                {0,1,0,0,1,0},
        };
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


//        ArrayList<Integer> dfs =  DfsOfGraph(adj,V);
//        System.out.println(dfs);
//        boolean[]visited = new boolean[V+1];
//        ArrayList<Integer> ans = new ArrayList<>();
//        dfs(1,visited,adj,ans);
//        System.out.println(ans);

       int ans = findCircleNum(isConnected);
        System.out.println(ans);
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

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);
        for(Integer i: adj.get(node)){
            if(!visited[i]){
                dfs(i,visited,adj,ans);
            }
        }
    }

//1 based index
    public static int  findCircleNum(int[][]isConnected){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 1;i<isConnected.length;i++){
            for(int j = 1;j<isConnected.length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[]visited = new boolean[adj.size()];

        int count = 0;
        for(int i =1;i<adj.size();i++){
            if(!visited[i]) {
                ArrayList<Integer>ans = new ArrayList<>();
                count++;
                dfs(i, visited, adj, ans);
            }
        }
        return count;
    }

}
