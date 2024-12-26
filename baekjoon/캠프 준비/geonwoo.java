import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_16938_캠프준비 {
	static int N, L, R, X, ans;
	static int [] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int idx, int min, int max, int sum) {
		if(idx == N) {
			if(sum < L || sum > R) return;
			if(max - min < X) return;
			
			ans++;
			return;
		}
		
		dfs(idx+1, min, max, sum);
		
		int now = nums[idx];
		
		min = Math.min(min, now);
		max = Math.max(max, now);
		
		dfs(idx+1, min, max, sum+now);
	}

}
