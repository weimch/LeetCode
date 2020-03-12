package sword_to_offer;

/**
 * P18DeleteDuplicatedNode
 */
public class P18DeleteDuplicatedNode {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    ListNode deleteDuplicateNode(ListNode head){
        // 因为是个已排序的数组，只用从头遍历到尾部，如果当前值和其下个节点值相同，则删除它的下个节点直到下个节点的值与当前值不同
        return null;
    }

    public static void main(String[] args) {
        // test1 重复节点在中间仅有一个
        // test2 重复节点在中间有多个
        // test3 重复节点在头部
        // test4 重复节点在尾部
        // test5 无重复节点
        // test6 仅有2个重复节点
        // test7 传入空指针
    }
}