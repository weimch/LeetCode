package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * P32LevelOrder1
 */
public class P32LevelOrder1 {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public int[] levelOrder(TreeNode root) {
        // 使用队列辅助的宽度优先搜索, 无重合进入队列的节点, 因此无需维护visited访问过的节点
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) continue;
            ans.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        int[] rans = new int[ans.size()];
        for(int i = 0; i < ans.size(); i ++){
            rans[i] = ans.get(i);
        }
        return rans;
    }
}