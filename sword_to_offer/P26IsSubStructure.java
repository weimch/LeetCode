package sword_to_offer;

/**
 * P26IsSubStructure
 */
public class P26IsSubStructure {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public boolean isTheSame(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        if(isTheSame(A.left, B.left) && isTheSame(A.right, B.right)){
            return true;
        }
        return false;
    }
    
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 递归比较当前A的值和B的值是否相等, 如果相等, 比较其左子树和右子树的值是否全部相等, 如果相等, 那么B就是A树的子结构
        if(A == null || B == null){
            return false;
        }
        if(isTheSame(A, B)){
            return true;
        }else{
            if(isSubStructure(A.left, B) || isSubStructure(A.right, B)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P26IsSubStructure sol = new P26IsSubStructure();

        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        // assert sol.isSubStructure(A, B);
        TreeNode B1 = new TreeNode(3);
        B1.left = new TreeNode(1);
        assert !sol.isSubStructure(A, B1);
    }
}