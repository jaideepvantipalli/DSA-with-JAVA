public class SubArraySum_Min_SlidingWindow1{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        System.out.print(findmin(a,n,k));
    }
    static int findmin(int a[],int n,int k){
        int s=0,min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++) s+=a[i];
        if(min>s) min=s;
        for(int i=1;i<=n-k;i++){
                s+=a[i+k-1];
                s-=a[i-1];
                if(min>s) min=s;
        }
        return min;
    }
}