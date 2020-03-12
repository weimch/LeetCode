package sword_to_offer;

import java.util.Arrays;

/**
 * P17Print1ToMaxOfNDigits
 */
public class P17Print1ToMaxOfNDigits {

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] ans = new int[max-1];
        for(int i = 1; i < max; i ++){
            ans[i-1] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        P17Print1ToMaxOfNDigits sol = new P17Print1ToMaxOfNDigits();
        sol.printNumbers(2);
        assert Arrays.equals(new int[]{1,2,3,4,5,6,7,8,9}, sol.printNumbers(1));
    }
}