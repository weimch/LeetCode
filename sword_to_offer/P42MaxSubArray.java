package sword_to_offer;

/**
 * P42MaxSubArray
 */
public class P42MaxSubArray {

    public int maxSubArray(int[] nums) {
        // 使用数组规律, 从头开始加到末尾, 记录当前的和
        // 1) 如果当前和<=0, 表示前面累加值不如当前的值, 直接从下个值开始
        // 2）当前和>0, 持续记录当前最大值
        int max_ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum <= 0){
                sum = 0;
                continue;
            }else{
                if(sum > max_ans){
                    max_ans = sum;
                }
            }
        }
        return max_ans;
    }
}