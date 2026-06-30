import java.util.*;

public class BfsMatrixWithoutStart {
    int n;
    int M[][];
    public BfsMatrixWithoutStart(int n) {
        this.n=n;
        M=new int[n][n];
    }
    void addEdge(int u,int v){
        M[u][v]=1;
        M[v][u]=1;
    }
    List<Integer> bfs(){
        List<Integer> res=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs_helper(i, vis, res);
            }
        }
        return res;
    }
    void bfs_helper(int start,boolean visited[],List<Integer> res){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int i=0;i<n;i++){
                if(M[curr][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        BfsMatrixWithoutStart obj=new BfsMatrixWithoutStart(n);
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
        System.out.println("BFS Traversal for disconnected graph : ");
        List<Integer> ans=obj.bfs();
        for(int x : ans){
            System.out.print(x+" ");
        }
        sc.close();
    }
}
