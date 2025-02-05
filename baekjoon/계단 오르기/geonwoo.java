import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 계단의 점수를 저장할 배열
		int [] stair = new int[N+1];
		// i번째 계단까지 도달했을 때 받을 수 있는 최대 점수를 저장할 배열
		int [] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		// 계단이 1, 2층인 경우는 정해진 최댓값을 출력하고 종료한다.
		if(N == 1) {
			System.out.println(stair[1]);
		} else if(N == 2) {
			System.out.println(stair[1]+stair[2]);
		} else {
			// 점화식으로 고려하여 3층까지 초기값을 설정해준다.
			dp[1] = stair[1];
			dp[2] = stair[1] + stair[2];
			dp[3] = stair[3] + Math.max(stair[1], stair[2]);
			
			for (int i = 4; i <= N; i++) {
				// i번째 계단에 도달하는 방법은 i-2번째 계단에서 2칸 올라오거나,
				// i-3번째 계단에서 2칸, i-1번째 계단에서 1칸 올라오는 방법밖에 없다.
				// 두 가지 방법 중 큰 값과 현재 계단에 쓰여진 점수를 더하여 dp배열에 넣는다.
				dp[i] = Math.max(dp[i-2], stair[i-1]+dp[i-3])+stair[i];
			}
			
			System.out.println(dp[N]);
		}
		
	}

}
