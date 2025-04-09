import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = sc.nextInt();
        }

        // 피보나치 수열 (최대 40까지)
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int prev = 0;
        int result = 1;

        for (int i = 0; i < M; i++) {
            int gap = vip[i] - prev - 1;
            result *= dp[gap];
            prev = vip[i];
        }

        result *= dp[N - prev];

        System.out.println(result);
    }
}
