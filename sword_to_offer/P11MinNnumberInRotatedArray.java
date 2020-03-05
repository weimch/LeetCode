package sword_to_offer;

/**
 * P11MinNnumberInRotatedArray
 */
public class P11MinNnumberInRotatedArray {

    public int minArray(int[] numbers) {
        // 使用二分查找来解决该问题，经过旋转后，数组分为左边排序数组和右边排序数组
        // 声明pleft和pright分别指向数组开始和结束，pmid=(pleft+pright)/2
        // pmid所指值，要么比pleft大(更新pleft)，要么比pright小(更新pright)
        // 如果pleft和pright相等，则遍历范围内元素找到最小值
        if(numbers[0] < numbers[numbers.length - 1]){
            return numbers[0];
        }
        int pleft = 0, pright = numbers.length - 1, pmid = 0;
        while(pright - pleft > 1){ //相邻或者重合
            if(numbers[pleft] == numbers[pright]){
                int min = Integer.MAX_VALUE;
                for(int i = pleft; i <= pright; i ++){
                    if(numbers[i] < min){
                        min = numbers[i];
                    }
                }
                return min;
            }
            pmid = (pleft + pright) / 2;
            if(numbers[pmid] >= numbers[pleft]){
                pleft = pmid;
            }
            if(numbers[pmid] <= numbers[pright]){
                pright = pmid;
            }
        }
        return numbers[pright];
    }

    public static void main(String[] args) {
        P11MinNnumberInRotatedArray sol = new P11MinNnumberInRotatedArray();
        assert sol.minArray(new int[]{3,3,1,3}) == 1;
        // test1: 非重复数字
        assert sol.minArray(new int[]{3,4,5,1,2}) == 1;
        // test2: 有重复数字
        assert sol.minArray(new int[]{2,2,2,0,1}) == 0;
        // test3: 旋转数组长度为0
        assert sol.minArray(new int[]{1,2,3,4}) == 1;
        // 异常情况都类似，空数组和空指针，这里除非题目特别要求，否则不再赘述
    }
}