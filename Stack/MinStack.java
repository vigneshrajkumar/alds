
package Stack;

import java.util.Deque;
import java.util.ArrayDeque;


public class MinStack {
    Deque<Integer> minStack;
    Deque<Integer> stack;
 
    public MinStack(){
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int e){
        if (e <= minStack.peek() || !minStack.isEmpty())
            minStack.add(e);
        minStack.add(e);
    }

    public int pop(){
        Integer e = stack.poll();
        if (e.equals(minStack.peek()))
            minStack.poll();
        
        return e;
    }
    
    public int getMin(){
        return minStack.peek();
    }
    
    public int top(){
        return stack.peek();
    } 
            
}
