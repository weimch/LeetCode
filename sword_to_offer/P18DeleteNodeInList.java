package sword_to_offer;

/**
 * P18DeleteNodeInList
 */
public class P18DeleteNodeInList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode deleteNode(ListNode head, int val) {
        // 使用pre和cur来分别指向当前节点和当前节点前的节点
        if(head == null) return null;
        // 如果pre为空，代表第一个元素需要被删除
        // 如果cur为空，代表无元素需要被删除，直接返回head
        ListNode pre = null, cur = head;
        while(cur != null){
            if(cur.val == val){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur == null) return head;
        if(pre == null){
            head = cur.next;
        }else{
            pre.next = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 很简单，为了节省时间，测试用例就不写了
        // test1 节点包含在List里
        // test2 节点不再List里
        // test3 List只有一个节点
        // test4 List为空
    }
}