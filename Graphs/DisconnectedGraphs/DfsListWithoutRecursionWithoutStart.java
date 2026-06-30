import java.util.*;

public class DfsListWithoutRecursionWithoutStart {
    int n;
    List<List<Integer>> M;
    public DfsListWithoutRecursionWithoutStart(int n) {
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
    List<Integer> dfs(){
        List<Integer> res=new ArrayList<>();
        boolean vis[]=new boolean[n];
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
        DfsListWithoutRecursionWithoutStart obj=new DfsListWithoutRecursionWithoutStart(n);
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
        List<Integer> ans=obj.dfs();
        for(int x : ans){
            System.out.print(x+" ");
        }
        sc.close();
    }
}
