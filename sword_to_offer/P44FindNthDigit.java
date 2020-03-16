package sword_to_offer;

/**
 * P44FindNthDigit
 */
public class P44FindNthDigit {

    public int findNthDigit(int n) {
        // 1) 确定n是几位数 0~9(9) 10~99(90) 100~999(900) ...
        // 2) 确定几位数中的哪个数
        // 3) 确定数字中的第几位
        n -= 1;
        for(long digits = 1; digits < 11; digits ++){
            long first_num = (long)Math.pow(10, digits-1);
            long range = 9 * first_num * digits;
            if(n < range){
                return (int)(String.valueOf(first_num + n/digits).charAt((int)(n%digits))-'0');
            }
            n -= range;
        }
        return 0;
    }

    public static void main(String[] args) {
        P44FindNthDigit sol = new P44FindNthDigit();
        assert sol.findNthDigit(3) == 3;
        assert sol.findNthDigit(10) == 1;
        assert sol.findNthDigit(11) == 0;
    }
}