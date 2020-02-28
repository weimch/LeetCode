package sword_to_offer;

import java.util.Stack;
/**
 * P09QueueWithTwoStacks
 */
public class P09QueueWithTwoStacks {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    static class CQueue {
        
        Stack<Integer> stack1, stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        
        public void appendTail(int value) {
            // 总是往stack1中添加元素
            stack1.push(value);
        }
        
        public int deleteHead() {
            // 当需要删除元素时，先判断stack2是否为空，如果为空，则载入stack1的元素，否则直接弹出stack2的元素
            // 当载入stack1元素时，stack1为空，则空队列，直接返回-1代表出错
            if(stack2.isEmpty()){
                if(stack1.isEmpty()){
                    return -1;
                }
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        // test1: 往空队列中添加若干元素
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        obj.appendTail(4);
        // test2: 往已有队列中删除元素
        assert 1 == obj.deleteHead();
        assert 2 == obj.deleteHead();
        // test3: 在删除若干元素之后再添加元素
        obj.appendTail(1);
        // test4: 持续删除元素直到元素为空
        assert 3 == obj.deleteHead();
        assert 4 == obj.deleteHead();
        assert 1 == obj.deleteHead();
        // test5: 删除空队列，返回-1
        assert -1 == obj.deleteHead();
    }

}