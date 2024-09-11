import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_16439_치킨치킨치킨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 회원들의 선호도를 저장할 2차원 배열
		int [][] prefer = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				prefer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		// 치킨 3종류를 각각 i, j, k라고 했을 때, 만족도의 합을 구한다.
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
				for (int k = j+1; k < M; k++) {
					int sum = 0;
					for (int l = 0; l < N; l++) {
						// 한 사람의 만족도는 시킨 치킨 중 선호도가 가장 큰 값이다.
						int best = Math.max(prefer[l][i], Math.max(prefer[l][j], prefer[l][k]));
						sum += best;
					}
					max = Math.max(max, sum);
				}
			}
		}
		
		System.out.println(max);
	}

}
