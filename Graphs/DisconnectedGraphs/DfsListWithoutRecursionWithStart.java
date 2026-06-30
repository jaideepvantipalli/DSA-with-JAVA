import java.util.*;

public class DfsListWithoutRecursionWithStart {
    int n;
    List<List<Integer>> M;
    public DfsListWithoutRecursionWithStart(int n) {
        this.n=n;
        M=new ArrayList<>();
        for(int i=0;i<n;i++){
            M.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v){
        M.get(u).add(v);
        M.get(v).add(u);
    }
    List<Integer> dfs(int start){
        List<Integer> res=new ArrayList<>();
        boolean vis[]=new boolean[n];
        vis[start]=true;
        res.add(start);
        dfs_helper(start, vis, res);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs_helper(i, vis, res);
            }
        }
        return res;
    }
    void dfs_helper(int s,boolean vis[],List<Integer> res){
        Stack<Integer> st=new Stack<>();
        st.push(s);
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                vis[node]=true;
                res.add(node);
            }
            for(int i : M.get(node)){
                if(!vis[i]){
                    st.push(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        DfsListWithoutRecursionWithStart obj=new DfsListWithoutRecursionWithStart(n);
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
