import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_17070_파이프옮기기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean [][] map = new boolean[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n == 1) map[i][j] = true;
			}
		}
		
		// 가로, 대각선, 세로
		int [][][] dp = new int[N+1][N+1][3];
		
		dp[1][2][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if((i == 1 && j == 2) || map[i][j]) continue;
				
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
				
				if(!map[i-1][j] && !map[i][j-1]) {					
					dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		
		int ans = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		System.out.println(ans);
		
	}

}
