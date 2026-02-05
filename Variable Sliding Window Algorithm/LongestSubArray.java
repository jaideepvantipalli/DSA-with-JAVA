public class LongestSubArray {

    public static void main(String[] args) {
        int a[]={10,5,2,7,1,-10,7,6,4,2};
        int n=a.length;
        int target=15;
        System.out.println(findlen(a,n,target));
    }
    private static int findlen(int a[],int n,int target){
        int res=0;
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=i;j<n;j++){
                s+=a[j];
                if(s==target){
                    int len=j-i+1;
                    if(res<len) res=len;
                }
            }
        }
        return res;
    }
}