package sword_to_offer;

/**
 * P33VerifyPostorder
 */
public class P33VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length <= 2) return true;
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int start, int end){
        // 子序列最后一个元素一定是当前子序列的根节点, 据此将子序列划分为左子树和右子树
        if(start >= end) return true;
        int split_idx = 0;
        for(; split_idx < end; split_idx ++){
            if(postorder[split_idx] > postorder[end]){
                break;
            }
        }
        // 验证后半边是否满足均大于根节点
        for(int i = split_idx; i < end; i ++){
            if(postorder[i] < postorder[end]){
                return false;
            }
        }
        return helper(postorder, start, split_idx - 1) && helper(postorder, split_idx, end - 1);
    }

    public static void main(String[] args) {
        P33VerifyPostorder sol = new P33VerifyPostorder();
        assert sol.verifyPostorder(new int[]{4, 6, 7, 5});
    }

}