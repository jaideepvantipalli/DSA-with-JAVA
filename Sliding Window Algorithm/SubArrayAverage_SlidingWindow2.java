public class SubArrayAverage_SlidingWindow2{
    public static void main(String[] args) {
        int a[]={10,50,60,80,90,100,20,60};
        int k=3;
        int n=a.length;
        int res[]=findsum(a,n,k);
        for(int i=0;i<res.length;i++) System.out.print(res[i]+" ");
    }
    static int[] findsum(int a[],int n,int k){
        int res[]=new int[n-k+1];
        int s=0;
        for(int i=0;i<k;i++) s+=a[i];
        res[0]=s/k;
        for(int i=k;i<n;i++){
                s+=a[i];
                s-=a[i-k];
                res[i-k+1]=s/k;
        }
        return res;
    }
}