import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 누적합을 저장할 배열
		int [] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + n;
		}
		
		int max = Integer.MIN_VALUE;
		
		// 슬라이딩 윈도우 + 누적합으로 최댓값을 갱신한다.
		for (int i = K; i <= N; i++) {
			max = Math.max(max, sum[i] - sum[i-K]);
		}
		
		System.out.println(max);
		
	}

}
