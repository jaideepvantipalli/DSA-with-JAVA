import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UGraphMatrix {
    int n;
    int M[][];
    public UGraphMatrix(int n) {
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
    public List<Integer> dfsTraversal(int src,boolean visited[]){
        Stack<Integer> st=new Stack<>();
        st.push(src);
        visited[src]=true;
        List<Integer> res=new ArrayList<>();
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
        return res;
    }

    public List<Integer> Bfs(int src){
        List<Integer> res=new ArrayList<>();
        boolean visited[]=new boolean[n];
        visited[src]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
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
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        UGraphMatrix obj=new UGraphMatrix(n);
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
            sc.close();
            return;
        }
        boolean visited[]=new boolean[n];
        System.out.println("DFS Traversal : ");
        List<Integer> ll=obj.dfsTraversal(src, visited);
        for(int i=0;i<ll.size();i++){
            System.out.print(ll.get(i)+" ");
        }
        List<Integer> bfsList=obj.Bfs(src);
        System.out.println("\nBFS Traversal : ");
        for(int i=0;i<bfsList.size();i++){
            System.out.print(bfsList.get(i)+" ");
        }

        obj.dfs(src, visited);
        sc.close();
    }
}