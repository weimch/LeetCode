package sword_to_offer;

/**
 * P15NumberOf1InBinary
 */
public class P15NumberOf1InBinary {

    public int hammingWeight(int n) {
        // 逐渐左移1，得到所有1
        int mask = 1, count = 0;
        while(mask != 0){
            if((n & mask) != 0){
                count += 1;
            }
            mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        P15NumberOf1InBinary sol = new P15NumberOf1InBinary();
        assert sol.hammingWeight(11) == 3;
        assert sol.hammingWeight(0) == 0;
    }
}