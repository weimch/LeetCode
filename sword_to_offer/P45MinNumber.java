package sword_to_offer;

import java.util.Arrays;

/**
 * P45MinNumber
 */
public class P45MinNumber {

    public String minNumber(int[] nums) {
        // 先按照规则把字符串进行排序, 保证左边拼接右边一定比右边拼接左边小
        // 最后将排序后的字符串串联起来就是结果
        String[] strnums = new String[nums.length];
        for(int i = 0; i < nums.length; i ++){
            strnums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strnums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for(String strnum : strnums){
            sb.append(strnum);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P45MinNumber sol = new P45MinNumber();
        assert sol.minNumber(new int[]{10,2}).equals("102");
        assert sol.minNumber(new int[]{3,30,34,5,9}).equals("3033459");
    }
}