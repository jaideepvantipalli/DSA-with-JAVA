import java.util.ArrayList;

public class SubArraySum_ArrayList_Slidingwindow1{
    public static void main(String[] args) {
        int a[]={6,4,3,9,-8,-2,10,6};
        int k=3;
        int n=a.length;
        ArrayList<Integer> al =findsum(a,n,k);
        for(int i=0;i<al.size();i++) System.out.print(al.get(i)+" ");
    }
    static ArrayList<Integer> findsum(int a[],int n,int k){
        ArrayList<Integer> al=new ArrayList<>();
        int s=0;
        for(int i=0;i<k;i++) s+=a[i];
        al.add(s);
        for(int i=1;i<=n-k;i++){
                s+=a[i+k-1];
                s-=a[i-1];
                al.add(s);
        }
        return al;
    }
}