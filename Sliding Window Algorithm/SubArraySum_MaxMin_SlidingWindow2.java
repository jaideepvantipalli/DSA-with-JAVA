import java.util.ArrayList;
public class SubArraySum_MaxMin_SlidingWindow2{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        ArrayList<Integer> al=findmaxmin(a, n, k);
        System.out.print("Max : " +al.get(0)+" Min : "+al.get(1));
    }
    static ArrayList<Integer> findmaxmin(int a[],int n,int k){
        ArrayList<Integer> al=new ArrayList<>();
        int s=0,max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++) s+=a[i];
        max=s;
        for(int i=k;i<n;i++){
                s+=a[i];
                s-=a[i-k];
                if(max<s) max=s;
        }
        al.add(max);
        int min=Integer.MAX_VALUE;
        s=0;
        for(int i=0;i<k;i++) s+=a[i];
        min=s;
        for(int i=k;i<n;i++){
                s+=a[i];
                s-=a[i-k];
                if(min>s) min=s;
        }
        al.add(min);
        return al;
    }
}