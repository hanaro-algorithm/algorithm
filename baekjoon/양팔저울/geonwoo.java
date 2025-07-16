import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_2629_양팔저울 {
	static int N;
	static int [] weight;
	static boolean [][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		weight = new int[N+1];
		dp = new boolean[N+1][45001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(dp[N][n]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void dfs(int idx, int sum) {
		if(dp[idx][sum]) return;
		
		dp[idx][sum] = true;
		
		if(idx == N) return;
		
		dfs(idx+1, sum);
		dfs(idx+1, sum + weight[idx+1]);
		dfs(idx+1, Math.abs(sum-weight[idx+1]));
		
	}

}
