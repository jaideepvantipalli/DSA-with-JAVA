package DSU Problems;

public class DSuGraph {
    int n;
    int M[][];
    public ConnectedGraphOrNot(int n) {
        this.n=n;
        M=new int[n][n];
    }
    public void addEdge(int u,int v){
        M[u][v]=1;
        M[v][u]=1;
    }   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        ConnectedGraph obj=new ConnectedGraph(n);
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
        List<List<Integer>> ans=obj.getComponents();
        for(List<Integer> x :ans){
            System.out.print(x+" ");
        }
        sc.close();
    }

}

