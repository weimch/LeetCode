package sword_to_offer;

import java.util.Arrays;

/**
 * P29SpiralOrder
 */
public class P29SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        // 按照 1)从左到右 2)从上到下 3)从右到左 4)从下到上的顺序 来遍历矩阵
        // 使用upper, right, down, left分别描述矩阵的边界
        if(matrix == null) return null;
        if(matrix.length == 0) return new int[]{};
        int uper = 0, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
        int idx = 0, ans_len = matrix.length * matrix[0].length;
        int[] ans = new int[ans_len];
        while(idx < ans_len){
            // 从左到右 - 更新上边界
            for(int i = left; i <= right; i ++){
                ans[idx ++] = matrix[uper][i];
            }
            if(idx == ans_len) break;
            uper ++;
            // 从上到下 - 更新右边界
            for(int i = uper; i <= down; i ++){
                ans[idx ++] = matrix[i][right];
            }
            if(idx == ans_len) break;
            right --;
            // 从右到左 - 更新下边界
            for(int i = right; i >= left; i --){
                ans[idx ++] = matrix[down][i];
            }
            if(idx == ans_len) break;
            down --;
            // 从下到上 - 更新左边界
            for(int i = down; i >= uper; i --){
                ans[idx ++] = matrix[i][left];
            }
            if(idx == ans_len) break;
            left ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P29SpiralOrder sol = new P29SpiralOrder();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        assert Arrays.equals(new int[]{1,2,3,6,9,8,7,4,5}, sol.spiralOrder(matrix));
        assert Arrays.equals(new int[]{1,2,3,4,8,12,11,10,9,5,6,7}, sol.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}