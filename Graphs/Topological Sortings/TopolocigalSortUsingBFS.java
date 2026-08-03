import java.util.*;
public class TopolocigalSortUsingBFS {
    public static List<Integer> TopoSort(List<List<Integer>> g,int n){
        
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j:g.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i:g.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=6;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
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
