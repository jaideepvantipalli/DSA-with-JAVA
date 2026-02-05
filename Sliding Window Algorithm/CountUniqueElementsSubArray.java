import java.util.HashSet;
public class CountUniqueElementsSubArray {
    public static void main(String[] args) {
        int a[]={3,4,5,3,3,5,6,5};
        int n=a.length;
        int k=3;
        int res[]=CountUniques(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] CountUniques(int a[],int n,int k){
        int res[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashSet<Integer> hs=new HashSet<>();
            hs.add(a[i]);
            for(int j=i+1;j<i+k;j++){
                hs.add(a[j]);
            }
            res[i]=hs.size();
        }
        return res;
    }
}
