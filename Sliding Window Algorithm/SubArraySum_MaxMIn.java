public class SubArraySum_MaxMin{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        int res[]=findmaxmin(a,n,k);
        System.out.print("MAX :" +res[0]+" "+"MIN :"+res[1]);
    }
    static int[] findmaxmin(int a[],int n,int k){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int s=0;
            for(int j=i;j<i+k;j++){
                s+=a[j];
            }
            if(s>max) max=s;
            if(s<min) min=s;
        }
        return new int[]{max,min};
    }
}