import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        dp[1] = score[1];
        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
