import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        int max = a[0];
        for (int i = 1; i < N; i++) {
            if (a[i] > max) max = a[i];
        }
        int LIMIT = max * K + 1;

        int[] dp = new int[LIMIT + 1];
        dp[0] = 0;
        for (int x = 1; x <= LIMIT; x++) {
            dp[x] = -1;
        }

        for (int x = 1; x <= LIMIT; x++) {
            int best = K + 1;
            for (int i = 0; i < N; i++) {
                int v = a[i];
                if (x - v >= 0 && dp[x - v] != -1) {
                    best = Math.min(best, dp[x - v] + 1);
                }
            }
            if (best <= K) {
                dp[x] = best;
            } else {
                dp[x] = -1;
            }

            if (dp[x] == -1) {
                if (x % 2 == 1) {
                    System.out.println("jjaksoon win at " + x);
                } else {
                    System.out.println("holsoon win at " + x);
                }
                return;
            }
        }
    }
}
