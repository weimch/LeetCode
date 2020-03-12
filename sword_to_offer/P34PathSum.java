package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * P34PathSum
 */
public class P34PathSum {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<>();
        if(root == null) return paths;
        dfs(root, new LinkedList<>(), 0, sum);
        return paths;
    }

    public void dfs(TreeNode node, LinkedList<Integer> path, int cursum, int sum){
        // 使用深度优先来遍历二叉树, 当遍历到叶节点时, 判断当前cursum=sum来加入路径
        if(node.left == null && node.right == null){
            if(cursum + node.val == sum){
                List<Integer> target = new ArrayList<>(path);
                target.add(node.val);
                paths.add(target);
            }
            return ;
        }
        path.add(node.val);
        if(node.left != null) dfs(node.left, path, cursum + node.val, sum);
        if(node.right != null) dfs(node.right, path, cursum + node.val, sum);
        path.removeLast();
    }

}