package daily_task;

/**
 * P2020_03_11
 */
public class P2020_03_11 {

    public boolean canThreePartsEqualSum(int[] A) {
        // 首先检查数组是否能被3整除
        // 然后计算分成3份之后，每部分的和记为psum=sum(A)/3
        // 从头遍历到坐标i, 直到[0,i]累加和等于psum
        // 从坐标i遍历到坐标j，直到[0,j]累加和等于2*psum
        int sum = 0;
        for(int ai = 0; ai < A.length; ai ++){
            sum += A[ai];
        }
        if(sum % 3 != 0){
            return false;
        }
        int psum = sum / 3;
        int i = -1, j = -1, cursum = 0, ai = 0;
        for(; ai < A.length; ai ++){
            cursum += A[ai];
            if(cursum == psum){
                i = ai;
                ai ++;
                break;
            }
        }
        if(i < 0) return false;
        for(; ai < A.length; ai ++){
            cursum += A[ai];
            if(cursum == 2 * psum){
                j = ai;
                break;
            }
        }
        if(j < 0 || j == A.length - 1) return false;
        return true;
    }

    public static void main(String[] args) {
        P2020_03_11 sol = new P2020_03_11();
        assert !sol.canThreePartsEqualSum(new int[]{1,-1,1,-1});
        assert sol.canThreePartsEqualSum(new int[]{12,-4,16,-5,9,-3,3,8,0});
        assert sol.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4});
        assert !sol.canThreePartsEqualSum(new int[]{6,1,1,13,-1,0,-10,20});
    }
}