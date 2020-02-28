package sword_to_offer;
import java.util.Arrays;
import java.util.Stack;
/**
 * P06PrintListInReversedOrder
 */
public class P06PrintListInReversedOrder {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        // 使用栈来存储元素，然后依次使用栈顶元素构建链表
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i ++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        P06PrintListInReversedOrder sol = new P06PrintListInReversedOrder();
        int[] ans;
        // test1: 链表中有一个元素
        ListNode root = new ListNode(1);
        ans = sol.reversePrint(root);
        assert Arrays.equals(ans, new int[]{1});
        // test2: 链表中有多个元素
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        ans = sol.reversePrint(root);
        assert Arrays.equals(ans, new int[]{3, 2, 1});
        // test3: 空链表
        ans = sol.reversePrint(null);
        assert Arrays.equals(ans, new int[]{});
    }
}