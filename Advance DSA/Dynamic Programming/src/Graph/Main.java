package Graph;

import java.util.ArrayList;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
//        adjacency matrix
//        adjacency list
        int vertices = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(7);

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0,3,40));
        graph.get(0).add(new Edge(0,1,10));

        graph.get(1).add(new Edge(1,0,10));
        graph.get(1).add(new Edge(1,2,10));

        graph.get(2).add(new Edge(2,3,10));
        graph.get(2).add(new Edge(2,1,10));

        graph.get(3).add(new Edge(3,0,40));
        graph.get(3).add(new Edge(3,2,10));
        graph.get(3).add(new Edge(3,4,2));

        graph.get(4).add(new Edge(4,3,2));
        graph.get(4).add(new Edge(4,5,3));
        graph.get(4).add(new Edge(4,6,3));


        graph.get(5).add(new Edge(5,4,3));
        graph.get(5).add(new Edge(5,6,3));

        graph.get(6).add(new Edge(6,5,3));
        graph.get(6).add(new Edge(6,4,8));

        for (int i = 0 ;i<vertices;i++){
            System.out.println(i + "->");
            for (Edge edge: graph.get(i)){
                System.out.print("(" + edge.nbr + ", " + edge.wt + ") ");
            }
            System.out.println();
        }

//        n = no of nodes
//        m = no of edges

//        USING ADJACENCY MATRIX
        int n = 3 ,m = 3;
        int[][]adj = new int[n+1][n+1];

//        edge 1--2
        adj[1][2]=1;
        adj[2][1] =1;

//        edge 2--3
        adj[2][3] = 1;
        adj[3][2] = 1;
//        edge 1--3
        adj[1][3] = 1;
        adj[3][1] = 1;


    }
}


