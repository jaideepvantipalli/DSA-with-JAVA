import java.util.Collections;
import java.util.PriorityQueue;

public class WindowMaxPriorityQueue{
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=maxwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] maxwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
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
