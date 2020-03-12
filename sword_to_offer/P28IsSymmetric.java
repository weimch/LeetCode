package sword_to_offer;

/**
 * P28IsSymmetric
 */
public class P28IsSymmetric {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public boolean isSymmetric(TreeNode root) {
        // 递归来判断, 左右子树是否互为镜像
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}