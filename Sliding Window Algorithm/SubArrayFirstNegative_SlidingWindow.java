import java.util.Deque;
import java.util.LinkedList;

public class SubArrayFirstNegative_SlidingWindow {
    public static void main(String[] args){
        int a[]={-8,2,3,-6,1};
        int n=a.length;
        int k=2;
        int res[]=firstnegative(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    static int[] firstnegative(int a[],int n,int k){
        Deque<Integer> dq=new LinkedList<>();
        int res[]=new int[n-k+1];
        for(int i=0;i<k;i++){
            if(a[i]<0) dq.add(a[i]);
        }
        res[0]=a[dq.peekFirst()];

        for(int i=k;i<n;i++){
            if(!dq.isEmpty()  && dq.peekFirst()<i+k-1) dq.pollFirst();
            if(a[i]<0) dq.add(i);
            res[i-k+1]=a[dq.peekFirst()];
        }
        return res;
    }

}
