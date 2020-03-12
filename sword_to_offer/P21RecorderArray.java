package sword_to_offer;

/**
 * P21RecorderArray
 */
public class P21RecorderArray {

    public int[] exchange(int[] nums) {
        // 如快速排序一样, 使用一个左指针, 始终指向左边偶数, 使用右指针, 始终指向右边奇数
        // 当左边指向偶数同时, 右边指向奇数, 则交换二者位置, 并且移动指针
        // 直到, 左边指针和右边指针重合或者左边指针大于右边指针
        int left = 0, right = nums.length - 1;
        boolean is_left_even = false, is_right_odd = false;
        while(left < right){
            is_left_even = nums[left] % 2 == 0;
            is_right_odd = nums[right] % 2 == 1;
            if(is_left_even && is_right_odd){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left ++;
                right --;
                continue;
            }
            if(!is_left_even){
                left ++;
            }
            if(!is_right_odd){
                right --;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        P21RecorderArray sol = new P21RecorderArray();
        int[] in = new int[]{1, 2, 3, 4};
        int[] out = sol.exchange(in);
        for(int i = 0; i < out.length; i ++){
            System.out.print(out[i] + " ");
        }
    }
}