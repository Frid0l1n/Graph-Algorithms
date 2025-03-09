import java.io.*;
import java.util.*;

public class articulation{

    public static void DFS(List<List<Integer>> adj, boolean[] visited, int start){
        //create stack for dfs
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            System.out.println("Hello");
        }
    }

    public static void Helper(List<List<Integer>> adj, int start){
        boolean[] visited = new boolean[adj.size()];
        DFS(adj, visited, start);
    }

    public static void main(String args[]){
        try {
            Scanner sc = new Scanner(new File("vertices.in"));
            int n = sc.nextInt();
            int m = sc.nextInt();
            int start = sc.nextInt();

            //create adjacency list
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++){
                adj.add(new ArrayList<Integer>());
            }

            //create the graph
            for (int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found: vertices.in");
        }
    }
}