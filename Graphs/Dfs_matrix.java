import java.util.Scanner;
public class Dfs_matrix {
    int n;
    int M[][];
    public Dfs_matrix(int n) {
        this.n=n;
        M=new int[n][n];
    }
    void addEdge(int u,int v){
        M[u][v]=1;
        M[v][u]=1;
    }
    void dfs(int src,boolean visited[]){
        visited[src]=true;
        System.out.print(src+" ");
        for(int i=0;i<n;i++){
            if(M[src][i]==1 && !visited[i]){
                dfs(i, visited);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        Dfs_matrix obj=new Dfs_matrix(n);
        while(true){
            System.out.print("Enter 1 for exit ,2 for add edge : ");
            int choice=sc.nextInt();
            if(choice==1){
                break;
            }
            if(choice==2){
                    System.out.print("Enter edge (u v) : ");
                    int u=sc.nextInt();
                    int v=sc.nextInt();
                    obj.addEdge(u,v);
                }
        }
        System.out.println("Enter the Starting vertex : ");
        int src=sc.nextInt();
        if(src<0 || src>=n){
            System.out.println("Invalid vertex");
            return;
        }
        boolean visited[]=new boolean[n];
        System.out.println("DFS Traversal : ");
        obj.dfs(src, visited);
        sc.close();
    }
}
