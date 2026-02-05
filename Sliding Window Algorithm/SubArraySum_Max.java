public class SubArraySum_Max{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        System.out.print(findmax(a,n,k));
    }
    static int findmax(int a[],int n,int k){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n-k;i++){
            int s=0;
            for(int j=i;j<i+k;j++){
                s+=a[j];
            }
            if(s>max) max=s;
        }
        return max;
    }
}