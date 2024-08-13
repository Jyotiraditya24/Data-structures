package StriverGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 9;
        for (int i = 0;i<=V;i++ ){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(6);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(2);

        adj.get(4).add(2);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(8);

        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(5);
        adj.get(8).add(7);

        adj.get(9).add(6);

        ArrayList<Integer> bfs = BfsOfGraph(V,adj);
        System.out.println(bfs);

    }

    public static ArrayList<Integer> BfsOfGraph(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[]visited = new boolean[V+1]; // for visiting nodes
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>ans = new ArrayList<>();

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int element = queue.remove();
            ans.add(element);

            ArrayList<Integer> localList = adj.get(element);
            for(Integer v : localList){
                if(visited[v]==false){
                    queue.add(v);
                    visited[v] = true;
                }
            }

        }
        return ans;

    }
}
