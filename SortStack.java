import java.util.*;
public class SortStack{
    
    public static void main(String args[]){
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(7);
        st.push(30);
        st.push(2);
        st.push(9);
        sortstack(st);
    }
    static void sortstack(Stack<Integer> st){
        Stack<Integer> temp=new Stack<>();
        while(!st.isEmpty()){
            int ele=st.pop();
            if(temp.isEmpty()) temp.push(ele);
            else{
                while(!temp.isEmpty() && temp.peek()< ele ){
                    st.push(temp.pop());
                }
                temp.push(ele);
            }
        }
        for(int i:temp) System.out.println(i+" ");
    }   
}