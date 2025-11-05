import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1106_호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[C+100];
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		
		for (int i = 1; i <= C+99; i++) {
			for (int j = 0; j < N; j++) {
				int cost = arr[j][0];
				int value = arr[j][1];
				
				if(value > i) continue;
				
				dp[i] = Math.min(dp[i], dp[i-value]+cost);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (int i = C; i <= C+99; i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.println(ans);
		
	}

}
