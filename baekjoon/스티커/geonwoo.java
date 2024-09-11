import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
            // 점수를 저장할 2차원 배열
			int [][] arr = new int[2][N+1];
            // 점수의 최댓값을 저장할 2차원 배열
			int [][] dp = new int[3][N+1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
            // 1. 위를 선택한 경우 -> 이전에서는 아래를 선택했거나 둘 다 선택하지 않아야 함
	        // 2. 아래를 선택한 경우 -> 이전에서는 위를 선택했거나 둘 다 선택하지 않아야 함
	        // 3. 둘 다 선택하지 않은 경우 -> 이전에서는 위를 선택했거나 아래를 선택했어야 함
			for (int i = 1; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];
				dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
			}
			
			int ans = Math.max(dp[0][N], Math.max(dp[1][N], dp[2][N]));
			sb.append(ans+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
		
	}

}