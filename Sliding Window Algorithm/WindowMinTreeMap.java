import java.util.Collections;
import java.util.TreeMap;
public class WindowMinTreeMap{
    public static void main(String[] args) {
        int a[]={1,3,-1,-3,5,3,6,7};
        int n=a.length;
        int k=3;
        int res[]=minwindow(a,n,k);
        for(int i:res) System.out.print(i+" ");
    }
    private static int[] minwindow(int a[],int n,int k){
        int res[]=new int[n-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        res[0]=map.firstKey();
        for (int i = 1; i <= n - k; i++) {
            int out = a[i - 1];
            if (map.get(out) == 1) {
                map.remove(out);
            } else {
                map.put(out, map.get(out) - 1);
            }
            int in = a[i + k - 1];
            map.put(in, map.getOrDefault(in, 0) + 1);
            res[i] = map.firstKey();
        }
        return res;
    }
}
