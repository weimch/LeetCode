package sword_to_offer;

import java.util.Stack;

/**
 * P31ValidateStackSequences
 */
public class P31ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟入栈出栈的操作, 每次循环入栈, 在每次循环内
        // 如果当前栈顶元素和当前popped的首部元素相同，则持续出栈, 直到不相同或者栈为空
        int pushed_idx = 0, poped_idx = 0;
        Stack<Integer> stack = new Stack<>();
        while(pushed_idx < pushed.length){
            stack.push(pushed[pushed_idx ++]);
            if(stack.peek() == popped[poped_idx]){
                while(!stack.empty() && stack.peek() == popped[poped_idx]){
                    stack.pop();
                    poped_idx ++;
                }
            }
        }
        // 未出栈完
        if(poped_idx < popped.length){
            while(!stack.empty() && stack.peek() == popped[poped_idx]){
                stack.pop();
                poped_idx ++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        P31ValidateStackSequences sol = new P31ValidateStackSequences();
        assert sol.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
        assert !sol.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
    }
}