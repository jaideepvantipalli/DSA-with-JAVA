import java.util.Scanner;
public class DirectedGraph {
    int n;
    int M[][];
    public DirectedGraph(int n) {
        this.n=n;
        M=new int[n][n];
    }
    void addEdge(int u,int v){
        M[u][v]=1;
    }
    void printgraph(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Nodes : ");
        int n=sc.nextInt();
        DirectedGraph obj=new DirectedGraph(n);
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
        obj.printgraph();
        sc.close();
    }
}
