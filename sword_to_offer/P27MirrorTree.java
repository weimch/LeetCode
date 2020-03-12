package sword_to_offer;

/**
 * P27MirrorTree
 */
public class P27MirrorTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode mirrorTree(TreeNode root) {
        // 递归交换每个节点的左右子节点
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}