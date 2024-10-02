import java.util.Scanner;

public class BOJ_S2_17213_과일서리 {	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		int M = scann.nextInt();
		
		// dp 알고리즘을 사용한다. (과일의 종류 / 훔칠 과일의 개수)
		int [][] dp = new int[N+1][M+1];
		
		// N이 1일 때에는 과일을 몇개 훔치던 경우의수가 1이므로 초기화 해준다.
		for (int i = 1; i <= M; i++) {
			dp[1][i] = 1;
		}
		
		// N이 2일때부터 훔칠 수 있는 경우의 수를 구해본다.
		for (int i = 2; i <= N; i++) {
			// M은 N보다 크거나 같으므로 j는 i부터 탐색한다.
			for (int j = i; j <= M; j++) {
				// 과일 i 종류를 j개 훔칠 때, 점화식은 다음과 같다 (직접 경우의 수를 계산하며 점화식 도출)
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
			}
		}
		
		System.out.println(dp[N][M]);

	}

}
