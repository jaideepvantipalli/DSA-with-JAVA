public class CountLongestSubArray {

    public static void main(String[] args) {
        int a[]={10,5,2,7,1,-10,7,6,4,2};
        int n=a.length;
        int target=15;
        System.out.println(findlen(a,n,target));
    }
    private static int findlen(int a[],int n,int target){
        int count=0,start=-1,end=-1;
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=i;j<n;j++){
                s+=a[j];
                if(s==target){
                    count++;
                    start=i;
                    end=j-i+1;
                    for(int idx=start;idx<=end;idx++) System.out.print(a[idx]+" ");
                    System.out.println();
                }
            }
        }
        return count;
    }
}