import java.util.*;
public class QuicksortHaorepartitioing{
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
        int pivot=a[l];
        int i=l-1,j=h+1;
        while(true){
            do { 
                i++;
            } while (a[i]<pivot);
            do { 
                j--;
            } while (a[j]>pivot);
            if(i>=j) return j;
            swap(a,i,j);   
        }
    }
    public static void qsort(int a[],int l,int h){
        if(l<h){
            int p=partition(a,l,h);
            qsort(a,l,p);
            qsort(a,p+1,h);
        }
    }
}