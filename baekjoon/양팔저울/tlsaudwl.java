import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        int maxWeight = 15000;

        boolean[][] dp = new boolean[N + 1][maxWeight + 1];
        dp[0][0] = true;

        for (int i = 0; i < N; i++) {
            int w = weights[i];
            for (int j = 0; j <= maxWeight; j++) {
                if (dp[i][j]) {
                    dp[i + 1][j] = true;

                    if (j + w <= maxWeight) {
                        dp[i + 1][j + w] = true;
                    }

                    int diff = Math.abs(j - w);
                    dp[i + 1][diff] = true;
                }
            }
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int ball = sc.nextInt();
            if (ball > maxWeight) {
                sb.append("N ");
            } else {
                sb.append(dp[N][ball] ? "Y " : "N ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
