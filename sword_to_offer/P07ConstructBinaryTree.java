package sword_to_offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * P07ConstructBinaryTree
 */
public class P07ConstructBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1) 使用前序遍历的第一个数，把中序遍历划分为左右子树
        // 2) 中序遍历左右子树的长度分别将前序遍历划分为左子树和右子树的前序遍历和
        // 3) 递归，不断地将数组分为左右子树，直到再无数组，表示左子树或者右子树为空
        // 4) 时间复杂度是O(log(n))，仅包含划分
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int idx = 0;
        for(; idx < inorder.length; idx ++){
            if(inorder[idx] == preorder[0]){
                break;
            }
        }
        int[] in_left = Arrays.copyOfRange(inorder, 0, idx);
        int[] in_right = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] pre_left = Arrays.copyOfRange(preorder, 1, 1 + in_left.length);
        int[] pre_right = Arrays.copyOfRange(preorder, 1 + in_left.length, preorder.length);
        node.left = buildTree(pre_left, in_left);
        node.right = buildTree(pre_right, in_right);
        return node;
    }

    public static void main(String[] args) {
        P07ConstructBinaryTree sol = new P07ConstructBinaryTree();
        int[] check;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        int check_idx;
        // test0: 满二叉树
        check = new int[]{3, 9, 20, 20, 8, 15, 7}; // 3 | 9, 20 | 20, 8, 15, 7
        check_idx = 0;
        queue.clear();
        queue.add(sol.buildTree(new int[]{3, 9, 20, 8, 20, 15, 7}, new int[]{20, 9, 8, 3, 15, 20, 7}));
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur == null){
                continue;
            }
            assert cur.val == check[check_idx ++];
            queue.add(cur.left);
            queue.add(cur.right);
        }
        // test1: 完全二叉树
        check = new int[]{3, 9, 20, 15, 7}; // 3 | 9 20 | 15 7
        check_idx = 0;
        queue.clear();
        queue.add(sol.buildTree(new int[]{3, 9, 15, 7, 20}, new int[]{15, 9, 7, 3, 20}));
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur == null){
                continue;
            }
            assert cur.val == check[check_idx ++];
            queue.add(cur.left);
            queue.add(cur.right);
        }
        // 下面测试用例类似，直接通过leecode了，下面就不再补充了
        // test2: 不完全二叉树
        // test3: 所有节点都没有左子节点
        // test4: 所有节点都没有右子节点
        // test5: 只有一个节点
        // test6: 不匹配的前序和中序遍历
        // test7: 空输入

    }
}