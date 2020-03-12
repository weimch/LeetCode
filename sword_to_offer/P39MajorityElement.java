package sword_to_offer;

import java.util.Arrays;

/**
 * P39MajorityElement
 */
public class P39MajorityElement {

    public int majorityElement(int[] nums) {
        // 排序取中位数
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}