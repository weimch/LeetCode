package sword_to_offer;

/**
 * P30MinStack
 */
import java.util.Stack;

public class P30MinStack {
    // 和返回队列最小元素一样, 使用辅助栈来存储最小值
    // 辅助栈的栈顶总是维护当前的最小元素
    // 当弹出元素和辅助栈栈顶一致时, 弹出辅助栈的栈顶
    Stack<Integer> stack, min;

    public P30MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if(min.empty()){
            min.push(x);
        }else{
            if(min.peek() >= x){
                min.push(x);
            }
        }
        stack.push(x);
    }
    
    public void pop() {
        int pop = stack.pop();
        if(!min.empty() && pop == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        P30MinStack minStack = new P30MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.min() == -3;
        minStack.pop();
        assert minStack.top() == 0;
        assert minStack.min() == -2;
    }
}