import java.util.*;

public class DfsMatrixWithoutRecursionWithStart {
    int n;
    int M[][];
    public DfsMatrixWithoutRecursionWithStart(int n) {
        this.n=n;
        M=new int[n][n];
    }
    void addEdge(int u,int v){
        M[u][v]=1;
        M[v][u]=1;
    }
    List<Integer> dfs(int start){
        List<Integer> res=new ArrayList<>();
        boolean vis[]=new boolean[n];
        vis[start]=true;
        dfs_helper(start, vis, res);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs_helper(i, vis, res);
            }
        }
        return res;
    }
    
    void dfs_helper(int src,boolean visited[],List<Integer> res){
        Stack<Integer> st=new Stack<>();
        st.push(src);
        visited[src]=true;
        while(!st.isEmpty()){
            int curr=st.pop();
            res.add(curr);
            for(int i=0;i<n;i++){
                if(M[curr][i]==1 && !visited[i]){
                    st.push(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        DfsMatrixWithoutRecursionWithStart obj=new DfsMatrixWithoutRecursionWithStart(n);
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
        System.out.println("DFS Traversal for disconnected graph : ");
        System.out.println("Enter starting node : ");
        int start=sc.nextInt();
        List<Integer> ans=obj.dfs(start);
        for(int x : ans){
            System.out.print(x+" ");
        }
        sc.close();
    }
}
