import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DSU{
    int n;
    static int parent[];
    DSU(int n){
        this.n=n;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public static void union(int x,int y){
        int x_root=find(x);
        int y_root=find(y);
        if(x_root==y_root){
            return;
        }
        parent[y_root]=x_root;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        DSU dsu=new DSU(n);
        while(true){
            System.out.println("1.Enter the pair of elements to union");
            System.out.println("2.Execute query whether friends or not");
            System.out.println("3.how many friendship groups are there");
            System.out.println("4.no of persons in each group ");
            System.out.println("5.Exit");
            System.out.println("Enter choice (1-5) :");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    int x=sc.nextInt();
                    int y=sc.nextInt();
                    union(x,y);
                    break;
                case 2:
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    if(find(a)==find(b)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                    break;
                case 3:
                    Set<Integer> groups=new HashSet<>();
                    for(int i=0;i<n;i++){
                        groups.add(find(i));
                    }
                    System.out.println("No of friendship groups are :"+groups.size());
                    break;
                case 4:
                    Map<Integer,Integer> groupSize=new HashMap<>();
                    for(int i=0;i<n;i++){
                        int root=find(i);
                        groupSize.put(root,groupSize.getOrDefault(root,0)+1);
                    }
                    System.out.println("No of persons in each group are :");
                    for(int i:groupSize.keySet()){
                        System.out.println("Group "+i+" has "+groupSize.get(i)+" persons");
                    }
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        //sc.close();
    }
}