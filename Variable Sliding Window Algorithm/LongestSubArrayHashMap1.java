import java.util.HashMap;
public class LongestSubArrayHashMap1 {

    public static void main(String[] args) {
        int a[]={10,5,2,7,1,-10,7,6,4,2};
        int n=a.length;
        int target=15;
        System.out.println(findlen(a,n,target));
    }
    private static int findlen(int a[],int n,int target){
        int res=0,psum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            psum+=a[i];
            if(psum==target) res=i;
            else if(hm.containsKey(psum-target)){
                int len=i-hm.get(psum-target);
                if(len>res) res=len;
            }
            if(!hm.containsKey(psum)){
                hm.put(psum,i);
            }
        }
        return res;
    }
}