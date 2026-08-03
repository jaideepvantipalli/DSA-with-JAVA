import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BipariteOrNotUsingDFS {
    private static boolean dfs(ArrayList<ArrayList<Integer>> adjList, int s, int col, int[] color) {
        color[s] = col;
        for (int x : adjList.get(s)) {
            if (color[x] == -1) {
                if (!dfs(adjList, x, 1 - col, color))
                    return false;
            }
            else if (color[x] == col) return false;
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
                if (!dfs(adjList, i, 0, color)) {
                    System.out.println("Not Biparite");
                    System.exit(0);
                }
            }
        }

        System.out.println("Biparite");
        sc.close();
    }
}