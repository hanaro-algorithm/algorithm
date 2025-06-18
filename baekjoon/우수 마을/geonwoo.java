import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G2_1949_우수마을 {
	static int N;
	static int [] people;
	static List<ArrayList<Integer>> list;
	static int [][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		dp = new int[N+1][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(1, 0);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}

	private static void dfs(int idx, int pastIdx) {
		dp[idx][1] += people[idx];
		
		for(int next : list.get(idx)) {
			if(next == pastIdx) continue;
			
			dfs(next, idx);
			
			dp[idx][0] += Math.max(dp[next][0], dp[next][1]);
			dp[idx][1] += dp[next][0];
		}
		
	}

}
