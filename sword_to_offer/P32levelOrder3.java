package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * P32levelOrder2
 */
public class P32levelOrder3 {
    
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // 按层打印二叉树, 每次均需要把队列中所有元素出队列
        // 作为上一题的变体, 只需要判断当前奇数层或偶数层即可完成操作
        // 如果当前层是奇数层, 则输出按照从左到右的顺序, 如果当前层是偶数层, 则变更输出为从右至左
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            Queue<TreeNode> nqueue = new LinkedList<>();
            LinkedList<Integer> level_out = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                level_out.add(node.val);
                if(node.left != null) nqueue.add(node.left);
                if(node.right != null) nqueue.add(node.right);
            }
            if((level & 0x1) == 0){
                LinkedList<Integer> r_level_out = new LinkedList<>();
                while(!level_out.isEmpty()){
                    r_level_out.add(level_out.removeLast());
                }
                level_out = r_level_out;
            }
            ans.add(level_out);
            queue = nqueue;
            level ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        P32levelOrder3 sol = new P32levelOrder3();
        sol.levelOrder(root);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        sol.levelOrder(root2);
    }
}