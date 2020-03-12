package sword_to_offer;

/**
 * P24ReverseList
 */
public class P24ReverseList {
    
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseList(ListNode head) {
        // 双指针, pre在后, cur在前, pre指向节点总是将其下个节点的指针指向cur
        ListNode cur = null, pre = head;
        while(pre != null){
            ListNode pre_next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = pre_next;
        }
        return cur;
    }

    public static void main(String[] args) {
        P24ReverseList sol = new P24ReverseList();

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i <= 5; i ++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ListNode ans = sol.reverseList(head);
        for(int i = 5; i >= 1; i --){
            assert ans.val == i;
            ans = ans.next;
        }
    }
}