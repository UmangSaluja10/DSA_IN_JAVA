import java.util.Arrays;

// Function for calculating the nth Fibonacci number
class GfG {
    static int fibo(int n) {
        int[] dp = new int[n + 1];

        // Storing the independent values in dp
        dp[0] = 0;
        dp[1] = 1;

        // Using the bottom-up approach
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibo(n));
    }
}