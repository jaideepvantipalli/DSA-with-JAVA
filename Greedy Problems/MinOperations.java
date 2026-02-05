import java.util.Scanner;
public class MinOperations{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ops=0;
        while(n>0){
            if(n%2==0){
                ops++;
                n/=2;
            }else{
                ops++;
                n-=1;
            }
        }
        System.out.println("Operations : "+ops);
    }
}