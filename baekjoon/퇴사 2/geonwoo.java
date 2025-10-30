import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N+2][2];
		int [] dp = new int[N+2];
		
		StringTokenizer st;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			arr[i][0] = t;
			arr[i][1] = p;
		}
		
		int max = -1;
		
		for (int i = 1; i <= N+1; i++) {
			if(max < dp[i]) max = dp[i];
			
			int next = arr[i][0]+i;
			int money = arr[i][1];
			
			if(next < N+2) {
				dp[next] = Math.max(dp[next], max+money);
			}
		}
		
		System.out.println(dp[N+1]);
		
	}

}
