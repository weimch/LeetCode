package sword_to_offer;

/**
 * P36TreeToDoublyList
 */
public class P36TreeToDoublyList {

    static class Node{
        int val;
        Node left, right;
        Node(){}
        Node(int _val){val = _val;}
        Node(int _val, Node _left, Node _right){
            val = _val;
            left = _left;
            right = _right;
        }
    }
    
    Node head, pre, tail;
    public Node treeToDoublyList(Node root) {
        // 使用中序遍历解题
        if(root == null) return null;
        head = pre = tail = null;
        inorder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inorder(Node node){
        if(node == null) return ;
        inorder(node.left);
        if(pre == null){
            head = node;
            pre = node;
        }else{
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        tail = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        P36TreeToDoublyList sol = new P36TreeToDoublyList();
        // sol.treeToDoublyList(root);
        Node root2 = new Node(-1);
        root2.right = new Node(1);
        root2.right.right = new Node(9);
        sol.treeToDoublyList(root2);
    }

}