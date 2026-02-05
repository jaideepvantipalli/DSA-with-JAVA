import java.util.*;
public class QuicksortLumutopartitioing{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        qsort(a,0,n-1);
        for(int i:a) System.out.print(i+" ");
    }
    public static void swap(int a[],int i,int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
    public static int partition(int a[],int l,int h){
        int pivot=a[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(a[j]<pivot){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,h);
        return i+1;
    }
    public static void qsort(int a[],int l,int h){
        if(l<h){
            int p=partition(a,l,h);
            qsort(a,l,p-1);
            qsort(a,p+1,h);
        }
        else return;
    }
}