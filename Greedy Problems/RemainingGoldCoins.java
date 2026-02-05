
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RemainingGoldCoins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
        pq.add(a[i]);
        }
        int v1,v2;
        while(pq.size()>1){
            v1=pq.poll();
            v2=pq.peek();
            if(v1==v2){
                pq.poll();
            }else{
                pq.poll();
                pq.add(Math.abs(v1-v2));
            }
        }
        if(!pq.isEmpty()) System.out.print(0);
        else System.out.print(pq.peek());
    }
}
