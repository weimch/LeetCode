package sword_to_offer;

/**
 * P16Power
 */
public class P16Power {

    public double myPow(double x, int n) {
        // 使用 x^n = x^(n/2) * x^(n/2) n 为偶数
        //      x^n = x^(n/2) * x^(n/2) * x n 为奇数递归完成处理
        // 当n为负数时，将其转化为正数，然后计算1.0/res的结果
        double base = n < 0 ? 1.0 / x : x;
        double res = 1.0;
        int exp = Math.abs(n);
        while(exp != 0){
            if((exp & 0x1) == 1){
                res *= base;
            }
            base *= base;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        P16Power sol = new P16Power();
        System.out.format("my:%f correct:%f\n", sol.myPow(2.0, 10), 1024.0);
        System.out.format("my:%f correct:%f\n", sol.myPow(2.1, 3), 9.26100);
        System.out.format("my:%f correct:%f\n", sol.myPow(2.0, -2), 0.25);
        System.out.format("my:%f correct:%f\n", sol.myPow(0.00001, 2147483647), 0.0);
    }
}