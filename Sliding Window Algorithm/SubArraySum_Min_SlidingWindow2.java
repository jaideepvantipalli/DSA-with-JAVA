public class SubArraySum_Min_SlidingWindow2{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        System.out.print(findmin(a,n,k));
    }
    static int findmin(int a[],int n,int k){
        int s=0,min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++) s+=a[i];
        min=s;
        for(int i=k;i<n;i++){
                s+=a[i];
                s-=a[i-k];
                if(min>s) min=s;
        }
        return min;
    }
}