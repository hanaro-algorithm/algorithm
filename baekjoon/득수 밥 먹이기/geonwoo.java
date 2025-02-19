import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S1_24464_득수밥먹이기 {
	static final int INF = 1000000007;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		
		// 0:굶기 1~4:방문한 식당 번호
		long [][] dp = new long[N][5];

		// 첫 날에는 굶거나 아무곳이나 갈 수 있다.
		Arrays.fill(dp[0], 1);
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4]) % INF;
			dp[i][1] = (dp[i-1][0] + dp[i-1][3] + dp[i-1][4]) % INF;
			dp[i][2] = (dp[i-1][0] + dp[i-1][4]) % INF;
			dp[i][3] = (dp[i-1][0] + dp[i-1][1]) % INF;
			dp[i][4] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % INF;
		}
		
		int ans = 0;
		
		for (int i = 0; i < 5; i++) {
			ans = (ans + (int)dp[N-1][i]) % INF;
		}
		
		System.out.println(ans);
		
	}

}
