public class SubArraySum_Max_SlidingWindow2{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        System.out.print(findmax(a,n,k));
    }
    static int findmax(int a[],int n,int k){
        int s=0,max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++) s+=a[i];
        max=s;
        for(int i=k;i<n;i++){
                s+=a[i];
                s-=a[i-k];
                if(max<s) max=s;
        }
        return max;
    }
}