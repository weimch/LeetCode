package sword_to_offer;

/**
 * P43CountDigitOne
 */
public class P43CountDigitOne {

    public int countDigitOne(int n) {
        // 将数分解, 递归求解
        if(n <= 0) return 0;
        String numstr = Integer.toString(n);
        int high = numstr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numstr.length()-1);
        int left = n - high * pow;
        if(high == 1){
            // 分解成, 1) 最高位为1时, 总共有多少个最高位为1的数 -> (left+1)
            //         2) 最高位为1时, left中会再出现多少个1 -> countDigitOne(left)
            //         3) 除了最高位为1外，剩余的部分会出现多少个1 -> countDigitOne(pow-1)
            return (left + 1) + countDigitOne(left) + countDigitOne(pow-1);
        }else{
            // 分解为, 1) 最高位不为1时, 那么最高位为1的数均小于该值 -> pow
            //         2) 最高位不为1时, 剩余部分会出现多少个1 -> high * countDigitOne(pow-1)
            //         3) left部分有多少个1
            return pow + high * countDigitOne(pow-1) + countDigitOne(left);
        }
    }

    public static void main(String[] args) {
        P43CountDigitOne sol = new P43CountDigitOne();
        sol.countDigitOne(12);
    }

}