import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2565_전깃줄 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] line = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// A 전봇대 기준으로 오름차순 정렬
		Arrays.sort(line, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});
		
		// i번째 전깃줄을 끝으로 했을 때 겹치지 않는 최대 전깃줄 개수
		int [] dp = new int[N];
		
		// B 전봇대 값 기준으로 겹치지 않는 최대 전깃줄 개수 계산
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			
			// i번 위에있는 전깃줄에 대해 확인한다.
			for (int j = 0; j < i; j++) {
				// 전깃줄이 교차하지 않으면
				if(line[i][1] > line[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
		
	}

}