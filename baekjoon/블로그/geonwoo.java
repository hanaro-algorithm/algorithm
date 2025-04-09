import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 누적합 알고리즘 사용
		int [] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + n;
		}
		
		int max = 0;
		int maxCnt = 0;
		
		// 슬라이딩 윈도우 알고리즘 사용
		for (int i = 0; i <= N-X; i++) {
			int diff = sum[i+X] - sum[i];
			
			if(diff > max) {
				max = diff;
				maxCnt = 1;
			} else if(diff == max) maxCnt++;
		}
		
		if(max != 0) {
			System.out.println(max);
			System.out.println(maxCnt);
		} else {
			System.out.println("SAD");
		}
		
	}

}
