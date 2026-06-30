import java.util.*;
public class ConnectedGraphOrNotCount2 {
    int n;
    int M[][];
    public ConnectedGraphOrNotCount2(int n) {
        this.n=n;
        M=new int[n][n];
    }
    public void addEdge(int u,int v){
        M[u][v]=1;
        M[v][u]=1;
    }
    Boolean getComponents(){
        List<List<Integer>> res=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> temp=new ArrayList<>();
                dfs_helper(i, vis, temp);
                res.add(temp);
            }
        }
        return res.size()>1?false:true;
    }
    void dfs_helper(int s,boolean vis[],List<Integer> res){
        vis[s]=true;
        res.add(s);
        for(int i=0;i<n;i++){
            if(M[s][i]==1 && !vis[i]){
                dfs_helper(i, vis, res);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        ConnectedGraphOrNotCount2 obj=new ConnectedGraphOrNotCount2(n);
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
        boolean res=obj.getComponents();
        if(res){
            System.out.println("Graph is connected");
        }else{
            System.out.println("Graph is disconnected");
        }
        sc.close();
    }
}
