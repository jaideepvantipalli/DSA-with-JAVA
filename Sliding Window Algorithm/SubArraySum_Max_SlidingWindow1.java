public class SubArraySum_Max_SlidingWindow1{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        System.out.print(findmax(a,n,k));
    }
    static int findmax(int a[],int n,int k){
        int s=0,max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++) s+=a[i];
        if(max<s) max=s;
        for(int i=1;i<=n-k;i++){
                s+=a[i+k-1];
                s-=a[i-1];
                if(max<s) max=s;
        }
        return max;
    }
}