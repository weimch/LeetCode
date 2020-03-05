package sword_to_offer;

/**
 * P10Fibonacci
 */
public class P10Fibonacci {

    public int fib(int n) {
        // 使用循环方式来计算，从0开始依次往上递增
        if(n == 0 || n == 1){
            return n;
        }
        int f_1 = 1, f_2 = 0, f = 0;
        for(int i = 2; i <= n; i ++){
            f = (f_1 + f_2) % 1000000007;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }

    public static void main(String[] args) {
        P10Fibonacci sol = new P10Fibonacci();
        assert sol.fib(45) == 134903163;
        assert sol.fib(2) == 1;
        assert sol.fib(5) == 5;
    }
}