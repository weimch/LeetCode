package sword_to_offer;

/**
 * P08NextNodeInBinaryTrees
 */
public class P08NextNodeInBinaryTrees {

    static class BinaryTreeNode{
        char val;
        BinaryTreeNode left, right, parent;
        BinaryTreeNode(char val){
            this.val = val;
        }
    }

    BinaryTreeNode getNext(BinaryTreeNode pNode){
        // 情况1：pNode有右子树，我们找到右子树的最左子节点即可，如果右子树仅有一个节点，则直接返回该节点
        // 情况2：pNode无右子树，该节点是父节点的左子节点，则返回父节点
        // 情况3：pNode无右子树，且该节点是父节点的右子节点，则顺着父节点找祖父节点，直到找到一个祖先，它是它父亲的左子节点，则返回它的父亲
        BinaryTreeNode cur, pre = null;
        if(pNode.right != null){
            cur = pNode.right;
            while(cur != null){
                pre = cur;
                cur = cur.left;
            }
            return pre;
        }
        if(pNode.parent.left == pNode){
            return pNode.parent;
        }
        cur = pNode.parent;
        while(cur != null && cur.parent != null){
            if(cur.parent.left == cur){
                return cur.parent;
            }
            cur = cur.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        P08NextNodeInBinaryTrees sol = new P08NextNodeInBinaryTrees();
        BinaryTreeNode a = new BinaryTreeNode('a');
        BinaryTreeNode b = new BinaryTreeNode('b');
        BinaryTreeNode c = new BinaryTreeNode('c');
        a.left = b;
        b.parent = a;
        a.right = c;
        c.parent = a;
        BinaryTreeNode d = new BinaryTreeNode('d');
        BinaryTreeNode e = new BinaryTreeNode('e');
        b.left = d;
        d.parent = b;
        b.right = e;
        e.parent = b;
        BinaryTreeNode h = new BinaryTreeNode('h');
        BinaryTreeNode i = new BinaryTreeNode('i');
        e.left = h;
        h.parent = e;
        e.right = i;
        i.parent = e;
        BinaryTreeNode f = new BinaryTreeNode('f');
        BinaryTreeNode g = new BinaryTreeNode('g');
        c.left = f;
        f.parent = c;
        c.right = g;
        g.parent = c;
        assert b == sol.getNext(d);
        assert c == sol.getNext(f);
        assert a == sol.getNext(i);
        assert null == sol.getNext(g);
    }
}