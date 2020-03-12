package sword_to_offer;

/**
 * P22KthNodeFromEnd
 */
public class P22KthNodeFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 使用2个指针, 当指针right距离第一个元素距离为k时, 指针left开始移动, 即left和right的距离为k
        // 当指针right移动到尾部时, 指针left所指元素即为目标值
        ListNode left = head, right = head;
        int dis_to_right = 1;
        while(right != null){
            right = right.next;
            if(dis_to_right <= k){
                dis_to_right ++;
            }else{
                left = left.next;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        P22KthNodeFromEnd sol = new P22KthNodeFromEnd();

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i <= 5; i ++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode ans = sol.getKthFromEnd(head, 2);
        assert ans.val == 4;
        assert ans.next != null;
        assert ans.next.val == 5;
    }
}