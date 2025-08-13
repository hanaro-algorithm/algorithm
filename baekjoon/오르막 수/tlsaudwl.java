import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N + 1][10];

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result += dp[N][j];
            result %= 10007;
        }

        System.out.println(result);
    }
}
