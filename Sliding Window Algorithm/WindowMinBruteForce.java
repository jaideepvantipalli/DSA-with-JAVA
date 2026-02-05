public class WindowMinBruteForce {
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=minwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] minwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            min=a[i];
            for(int j=i+1;j<i+k;j++){
                if(min>a[j]) min=a[j];
            }
            res[i]=min;
        }
        return res;
    }
}
