public class SubArrayFirstNegative {
    public static void main(String[] args){
        int a[]={-8,2,3,-6,1};
        int n=a.length;
        int k=2;
        int res[]=firstnegative(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    static int[] firstnegative(int a[],int n,int k){
        int res[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            int neg=0;
            for(int j=i;j<i+k;j++){
                if(a[j]<0){
                    neg=a[j];
                    break;
                }
            }
            if(neg==0) res[i]=0;
            else res[i]=neg;
        }
        return res;
    }

}
