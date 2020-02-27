package sword_to_offer;

/**
 * P3FindInPartiallySortedMatrix
 */
public class P03FindInPartiallySortedMatrix {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 排除异常情况
        if(matrix == null || matrix.length == 0){
            return false;
        }
        // 从右上到左下，逐步排除行或列，因此，排除行列之后，总是具有右上角的元素
        // 1) 如果一个数大于右上角元素，则排除行
        // 2) 如果一个数小于右上角元素，则排除列
        // 3) 如果一个数等于右上角元素，则返回true
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1; // 从左上角开始
        while(i < rows && j >= 0){
            if(target > matrix[i][j]){
                i ++;
            }else if(target < matrix[i][j]){
                j --;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P03FindInPartiallySortedMatrix sol = new P03FindInPartiallySortedMatrix();
        int[][] matrix1 = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 42}
        };
        boolean ans;
        // test1: 能够查找到元素
        ans = sol.findNumberIn2DArray(matrix1, 13);
        assert ans;
        // test2: 查找元素大于数组中最大值
        ans = sol.findNumberIn2DArray(matrix1, 100);
        assert !ans;
        // test3: 查找元素小于数组中最小值
        ans = sol.findNumberIn2DArray(matrix1, 0);
        assert !ans;
        // test4: 查找元素在数组最大值和最小值之间，但不存在
        ans = sol.findNumberIn2DArray(matrix1, 36);
        assert !ans;
        // test5: 异常情况 - 空引用
        ans = sol.findNumberIn2DArray(null, 1);
        assert !ans;
        // test6: 异常情况 - 元素个数为0的二维举证
        ans = sol.findNumberIn2DArray(new int[][]{}, 1);
        assert !ans;
    }
}