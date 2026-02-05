import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class WindowMinDeque{
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=minwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] minwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && a[dq.peekLast()]>=a[i]) 
                dq.removeFirst();
            dq.addLast(i);
        }
        res[0]=a[dq.peekFirst()];
        for(int i=k;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k) 
                dq.removeFirst();
            while(!dq.isEmpty() && a[dq.peekLast()]>=a[i]) 
                dq.removeLast();
            dq.addLast(i);
            res[i-k+1]=a[dq.peekFirst()];
        }
        return res;
    }
}
