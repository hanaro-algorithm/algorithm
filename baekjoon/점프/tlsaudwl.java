import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) continue;

                int jump = board[i][j];

                if (i + jump < N) {
                    dp[i + jump][j] += dp[i][j];
                }

                if (j + jump < N) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
