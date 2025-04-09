import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2302_극장좌석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 다이나믹 프로그래밍을 이용하여 연속된 좌석에 대한 경우의 수 구하기
		int [] dp = new int[N+1];
		
		// 초기값 설정
		dp[0] = 1;
		dp[1] = 1;
		
		// 연속된 좌석의 경우의 수가 피보나치 수열의 형태를 띈다.
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		int [] vip = new int[M];
		
		for (int i = 0; i < M; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 1;
		int lastIdx = 0;
		
		// 연속된 좌석의 수를 구하고, 그 때마다 경우의 수를 구하여 ans에 곱해준다.
		for(int idx : vip) {
			int diff = (idx-1) - lastIdx;
			
			ans *= dp[diff];
			lastIdx = idx;
		}
		
		// 마지막 남은 연속된 좌석의 경우의 수 곱하기
		ans *= dp[N - lastIdx];
		
		System.out.println(ans);
		
	}

}