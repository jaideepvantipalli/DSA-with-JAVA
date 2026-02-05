import java.util.Collections;
import java.util.PriorityQueue;

public class WindowMinPriorityQueue{
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=minwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] minwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++) pq.offer(a[i]);
        res[0]=pq.peek();
        for(int i=1;i<=n-k;i++){
            pq.offer(a[i+k-1]);
            pq.remove(a[i-1]);
            res[i]=pq.peek();
        }
        return res;
    }
}
