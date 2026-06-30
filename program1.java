
import java.util.HashMap;
import java.util.Scanner;
public class program1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s=sc.next();
        sc.nextLine();
        int count=substrings(s);
        System.out.println("Number of Substrings : "+count);
        sc.close();
    }
    private static int substrings(String s){
           int n=s.length();
           HashMap<Character,Integer> hm=new HashMap<>();
           int left=0;
           int count=0;
           for(int right=0;right<s.length();right++){
               char c=s.charAt(right);
               hm.put(c,hm.getOrDefault(c,0)+1);
               while(hm.size()==3){
                   char ch=s.charAt(left);
                   hm.put(ch,hm.get(ch)-1);
                   if(hm.get(ch)==0){
                       hm.remove(ch);
                   }
                   count+=n-right;
                   left++;
               }
        }
        return count;
    }
}
