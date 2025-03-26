import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 포도주의 양을 저장할 배열
		int [] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 안마시는 경우, 마셔서 연속 1잔인 경우, 마셔서 연속 2잔인 경우로 나눠서 저장한다.
		int [][] dp = new int[N][3];
		// 초기 조건으로 첫 포도주를 마셨을 때의 dp 배열을 초기화한다.
		dp[0][1] = arr[0];
		
		for (int i = 1; i < N; i++) {
			// i번째 포도주를 안 마시는 경우에는
			// i-1번째 포도주를 안마시거나, 마셔서 연속 1잔, 연속 2잔일 때 중 가장 큰 값을 가져온다.
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			// i번째 포도주를 마셔서 연속 1잔인 경우는 이전에 마시지 않았어야 한다.
			dp[i][1] = dp[i-1][0] + arr[i];
			// i번째 포도주를 마셔서 연속 2잔인 경우는 이전에 연속 1잔이어야 한다.
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		
		int max = 0;
		
		// 3가지 경우 중 가장 큰 값을 max에 갱신한다.
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[N-1][i]);
		}
		
		System.out.println(max);
		
	}

}
