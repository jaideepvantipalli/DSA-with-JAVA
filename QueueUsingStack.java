import java.util.*;

public class QueueUsingStack{
    static Stack<Integer> st1=new Stack<>();
    static Stack<Integer> st2=new Stack<>();
    public static void main(String args[]){
        enque(10);
        enque(20);
        enque(30);
        enque(40);
        deque();
        peek();
    }
    static void enque(int x){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    static void deque(){
        if(!st1.isEmpty())
        System.out.println(st1.pop());
    }
    static void peek(){
        if(!st1.isEmpty())
        System.out.println(st1.pop());
    }
}