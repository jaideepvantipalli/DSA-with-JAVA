import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipariteOrNotUsingBFS {
    private static boolean bfs(ArrayList<ArrayList<Integer>> adjList, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adjNode : adjList.get(node)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    q.offer(adjNode);
                }
                else if (color[adjNode] == color[node]) 
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // check for biparite or not
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(adjList, i, color)) {
                    System.out.println("Not Biparite");
                    System.exit(0);
                }
            }
        }

        System.out.println("Biparite");
        sc.close();
    }
}