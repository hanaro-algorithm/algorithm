import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] soldiers = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            soldiers[i] = sc.nextInt();
            dp[i] = 1;
        }

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (soldiers[j] > soldiers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(n - maxLength);
    }
}
