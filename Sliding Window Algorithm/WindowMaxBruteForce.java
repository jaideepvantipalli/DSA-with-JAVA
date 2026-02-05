public class WindowMaxBruteForce {
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=maxwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] maxwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n-k;i++){
            max=a[i];
            for(int j=i+1;j<i+k;j++){
                if(max<a[j]) max=a[j];
            }
            res[i]=max;
        }
        return res;
    }
}
