import java.util.*;

public class bipartiteGraph {

    public static void BFS(List<List<Integer>> adj, int s){
        //define visited array
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        System.out.println(s);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for (int i : adj.get(curr)){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    System.out.println(i);
                }
            }
        }
    }

    public static boolean isBipartite(List<List<Integer>> adj, int s){
        //define colorized
        int[] colors = new int[adj.size()];
        Arrays.fill(colors, -1);
        Queue<Integer> q = new LinkedList<>();

        colors[s] = 0;
        q.offer(s);
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int i : adj.get(curr)){
                if (colors[curr] == -1){
                    colors[curr] = 1 - colors[i];
                    q.offer(i);
                }

                else if (colors[curr] == colors[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void addEdges(List<List<Integer>> adj, int s, int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }
    public static void main(String[] args){
        int[][] edges = {{1, 3},{1, 6},{2, 3},{2, 4},{2, 6},{5, 3}, {5, 6}};
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 7; i++){
            adj.add(new ArrayList<Integer>());
       }

       for (int[] e : edges){
        addEdges(adj, e[0], e[1]);
       }

       BFS(adj, 1);
       System.out.println(isBipartite(adj, 1));
    }
}
