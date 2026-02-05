import java.util.HashMap;
public class CountUniqueElementsSubArray_Slidingwindow {
    public static void main(String[] args) {
        int a[]={3,4,5,3,3,5,6,5};
        int n=a.length;
        int k=3;
        int res[]=CountUniques(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] CountUniques(int a[],int n,int k){
        int res[]=new int[n-k+1];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++) 
            hm.put(a[i],hm.getOrDefault(a[i],0)+1);
        res[0]=hm.size();
        for(int i=1;i<=n-k;i++){
            hm.put(a[i+k-1],hm.getOrDefault(a[i+k-1],0)+1);
            hm.put(a[i-1],hm.get(a[i-1])-1);
            if(hm.get(a[i-1])==0){
                hm.remove(a[i-1]);
            }
            res[i]=hm.size();
        }
        return res;
    }
}
