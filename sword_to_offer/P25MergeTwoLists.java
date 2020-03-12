package sword_to_offer;

/**
 * P25MergeTwoLists
 */
public class P25MergeTwoLists {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = null, head = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(ans == null){
                    ans = l1;
                    head = ans;
                }else{
                    ans.next = l1;
                    ans = ans.next;
                }
                l1 = l1.next;
            }else{
                if(ans == null){
                    ans = l2;
                    head = ans;
                }else{
                    ans.next = l2;
                    ans = ans.next;
                }
                l2 = l2.next;
            }
        }
        if(l1 != null){
            if(ans == null){
                head = l1;
            }else{
                ans.next = l1;
            }
        }
        if(l2 != null){
            if(ans == null){
                head = l2;
            }else{
                ans.next = l2;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        P25MergeTwoLists sol = new P25MergeTwoLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode ans = sol.mergeTwoLists(l1, l2);
        int[] standard = new int[]{1, 1, 2, 3, 4, 4};
        for(int i = 0; i < standard.length; i ++){
            assert standard[i] == ans.val;
            ans = ans.next;
        }
    }
}