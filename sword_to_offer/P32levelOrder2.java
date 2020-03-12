package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * P32levelOrder2
 */
public class P32levelOrder2 {
    
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // 按层打印二叉树, 每次均需要把队列中所有元素出队列
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> nqueue = new LinkedList<>();
            List<Integer> level_out = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                level_out.add(node.val);
                if(node.left != null) nqueue.add(node.left);
                if(node.right != null) nqueue.add(node.right);
            }
            ans.add(level_out);
            queue = nqueue;
        }
        return ans;
    }
}