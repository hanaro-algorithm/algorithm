import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 수들의 누적합을 저장할 배열
		int [] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		// 1번째 수부터 N번째 수까지 누적합을 구한다. (현재 값 = 이전 값 + i번째 수)
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + n;
		}
		
		StringBuilder sb = new StringBuilder();
		// 구간 합을 누적합 배열을 통해 O(1) 시간만에 구할 수 있다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end] - sum[start-1]+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
