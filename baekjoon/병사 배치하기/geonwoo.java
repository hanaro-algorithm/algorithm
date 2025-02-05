import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_18353_병사배치하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 병사의 전투력을 저장할 배열
		int [] power = new int[N];
		// i번째 병사까지 가장 긴 감소하는 부분 수열의 길이를 저장할 배열
		int [] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
			// 자기 자신만으로 길이가 1이므로 1로 초기화해준다.
			dp[i] = 1;
		}
		
		// 가장 긴 감소하는 부분 수열의 길이
		int max = 1;
		
		// i번째 병사부터 N-1번째 병사까지 확인해보며 가장 긴 감소하는 부분수열의 길이를 갱신한다.
		for (int i = 1; i < N; i++) {
			// i번째 이전의 병사들을 모두 확인해본다.
			for (int j = 0; j < i; j++) {
				// 만약 j번째 병사가 i번째 병사(현재 병사)보다 전투력이 높다면
				if(power[j] > power[i]) {
					// dp[i]를 j번째 병사의 부분수열 길이+1과 비교하여 갱신한다.
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			// 가장 긴 감소하는 부분 수열의 길이를 갱신한다.
			max = Math.max(max, dp[i]);
		}
		
		// 열외해야 하는 병사를 출력해야 하므로, 전체 인원에서 max를 빼준다.
		System.out.println(N-max);
		
	}

}
