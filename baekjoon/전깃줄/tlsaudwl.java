import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }

        Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = lines[i][1];
        }

        int[] dp = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (b[j] < b[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(n - maxLen);
    }
}
