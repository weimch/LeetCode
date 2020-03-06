package sword_to_offer;

/**
 * P14CuttingRopeII
 */
public class P14CuttingRopeII {

    public int cuttingRope(int n) {
        // 使用贪婪法来求解，然鹅觉得自己单独想也想不出来
        if(n < 1) return 0;
        if(n == 2 || n == 3) return n - 1;
        // 尽可能地减去长度为3的绳子段
        long ans = 1;
        while(n > 4){
            ans = ans * 3 % 1000000007;
            n -= 3;
        }
        return (int)(ans * n % 1000000007);
    }

    public static void main(String[] args) {
        P14CuttingRopeII sol = new P14CuttingRopeII();
        assert sol.cuttingRope(120) == 953271190;
        assert sol.cuttingRope(2) == 1;
        assert sol.cuttingRope(8) == 18;
        assert sol.cuttingRope(10) == 36;
    }
}