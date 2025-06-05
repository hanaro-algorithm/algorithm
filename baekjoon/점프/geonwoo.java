import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1890_점프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 출력의 범위가 2^63-1 까지이므로 long으로 dp배열 선언
		long [][] dp = new long[N][N];
		// 초기값 설정
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 현재 칸에서 몇 칸 점프할 수 있는지 저장할 변수
				int next = map[i][j];
				
				// 마지막 칸에 도달했으면 종료한다.
				if(i == N-1 && j == N-1) break;
				
				// 아래로 점프했을 때, 맵 밖으로 벗어나지 않으면 해당 칸에 현재 칸 경우의 수를 추가한다.
				if(i+next < N) {
					dp[i+next][j] += dp[i][j];
				}
				
				// 오른쪽으로 점프했을 때, 맵 밖으로 벗어나지 않으면 해당 칸에 현재 칸 경우의 수를 추가한다.
				if(j+next < N) {
					dp[i][j+next] += dp[i][j];
				}
			}
		}
		
		// 마지막 칸 도달 경우의 수 출력
		System.out.println(dp[N-1][N-1]);
		
	}

}
