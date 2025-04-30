import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_17484_진우의달여행_Small {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N][M];
		// 왼중오
		int [][][] dp = new int[N][M][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], 1000001);
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				dp[0][i][j] = arr[0][i];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(j == 0) {
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
					dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
				} else if(j == M-1) {
					dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + arr[i][j];
				} else {
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + arr[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(min, dp[N-1][i][j]);
			}
		}
		
		System.out.println(min);
		
	}

}
