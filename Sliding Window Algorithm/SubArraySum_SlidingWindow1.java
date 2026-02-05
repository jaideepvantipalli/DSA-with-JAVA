public class SubArraySum_SlidingWindow1{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        int res[]=findsum(a,n,k);
        for(int i=0;i<res.length;i++) System.out.print(res[i]+" ");
    }
    static int[] findsum(int a[],int n,int k){
        int res[]=new int[n-k+1];
        int s=0;
        for(int i=0;i<k;i++) s+=a[i];
        res[0]=s;
        for(int i=1;i<=n-k;i++){
                s+=a[i+k-1];
                s-=a[i-1];
                res[i]=s;
        }
        return res;
    }
}