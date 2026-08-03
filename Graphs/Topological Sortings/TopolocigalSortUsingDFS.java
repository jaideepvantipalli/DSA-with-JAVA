import java.util.*;
public class TopolocigalSortUsingDFS {
    public static List<Integer> TopoSort(List<List<Integer>> g,int n){
        boolean[] vis=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,g,st);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public static void dfs(int node,boolean[] vis,List<List<Integer>> g,Stack<Integer> st){
        vis[node]=true;
        for(int it:g.get(node)){
            if(!vis[it]){
                dfs(it,vis,g,st);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        int e=sc.nextInt();
        while(e-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            g.get(x).add(y);
        }
        
        List<Integer> ans=TopoSort(g,n);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
