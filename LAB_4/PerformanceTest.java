public class PerformanceTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 45; i++) {
            System.out.println(fibonacci(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    public static int fibonacci_dp(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}