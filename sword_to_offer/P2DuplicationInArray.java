package sword_to_offer;

public class P2DuplicationInArray {
    // 方法一：使用哈希表
    // public int findRepeatNumber(int[] nums) {
    //     boolean[] is_occupy = new boolean[nums.length];
    //     for(int i = 0; i < nums.length; i ++){
    //         if(!is_occupy[nums[i]]){
    //             is_occupy[nums[i]] = true;
    //         }else{
    //             return nums[i];
    //         }
    //     }
    //     return 0;
    // }
    // 方法二：使用重排数组
    public int findRepeatNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0;
        while(i < nums.length){
            int m = nums[i];
            if(m == i){
                i ++;
            }else if(m == nums[m]){
                return m;
            }else{
                int tmp = nums[m];
                nums[m] = m;
                nums[i] = tmp;
            }            
        }
        return -1;
    }

    public static void main(String[] args) {
        P2DuplicationInArray sol = new P2DuplicationInArray();
        // test1: 包含一个或者多个重复数字
        int ans1 = sol.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        assert ans1 == 2 || ans1 == 3;
        // test2: 不包含重复数字，这里返回-1
        int ans2 = sol.findRepeatNumber(new int[]{2, 3, 4, 1, 0});
        assert ans2 == -1;
        // test3: 无效输入 - 空指针
        int ans3 = sol.findRepeatNumber(null);
        assert ans3 == -1;
        // test4: 无效输入 - 长度为0的数组
        int ans4 = sol.findRepeatNumber(new int[]{});
        assert ans4 == -1;
    }
}