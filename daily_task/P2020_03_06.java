package daily_task;

import java.util.ArrayList;
import java.util.List;

/**
 * P2020-03-06
 */
public class P2020_03_06 {

    public int[][] findContinuousSequence(final int target) {
        // 使用滑动窗口解题，left和right分别为指向第一个元素和第二个元素，此时划分了一个区间[left,right]
        // 当区间内的和<target时，向右移动right,
        // 当区间内的和>target时，向右移动left。
        // 当区间内的和=target时，找到区间，存储结果
        // 一直执行，直到，right在末尾，但是区间内的和<target
        if(target == 1) return new int[][]{{1}};
        int boundary = (target + 1) / 2;
        int left = 1, right = 1, sum = 1;
        List<List<Integer>> ans = new ArrayList<>();
        while(true){
            if(right == boundary && sum < target){
                break;
            }
            if(sum < target){
                right ++;
                sum += right;
            }else if(sum > target){
                sum -= left;
                left ++;
            }else{
                List<Integer> tuple = new ArrayList<>();
                for(int i = left; i <= right; i ++){
                    tuple.add(i);
                }
                ans.add(tuple);
                sum -= left;
                left ++;
            }
        }
        int[][] ansls = new int[ans.size()][];
        for(int i = 0; i < ans.size(); i ++){
            ansls[i] = new int[ans.get(i).size()];
            for(int j = 0; j < ans.get(i).size(); j ++){
                ansls[i][j] = ans.get(i).get(j);
            }
        }
        return ansls;
    }

    private static boolean is_list_equal(final int[][] a, final int[][] b){
        if(a.length != b.length) return false;
        for(int i = 0; i < a.length; i ++){
            if(a[i].length != b[i].length){
                return false;
            }
            for(int j = 0; j < a[i].length; j ++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        final P2020_03_06 sol = new P2020_03_06();
        assert is_list_equal(sol.findContinuousSequence(9), new int[][]{{2,3,4},{4,5}});
        assert is_list_equal(sol.findContinuousSequence(15), new int[][]{{1,2,3,4,5},{4,5,6},{7,8}});
    }
    
}