import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] P = new int[N + 1];   // 가격 배열 (1-indexed)
        int[] dp = new int[N + 1];  // dp 배열

        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
