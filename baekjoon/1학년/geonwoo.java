import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_5557_1학년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		long [][] dp = new long[N+1][21];		
		dp[1][nums[1]] = 1;
		
		for (int i = 2; i < N; i++) {
			int num = nums[i];
			
			for (int j = 0; j <= 20; j++) {
				long plus = j-num < 0 ? 0 : dp[i-1][j-num];
				long minus = j+num > 20 ? 0 : dp[i-1][j+num];
				
				dp[i][j] = plus + minus;
			}
		}
		
		System.out.println(dp[N-1][nums[N]]);
		
	}

}
