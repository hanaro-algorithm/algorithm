import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14501_퇴사 {
	static int N;
	static int max = -1;
	static int [] arr, value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 걸리는 기간을 저장할 배열
		arr = new int[N+1];
		// 받는 금액을 저장할 배열
		value = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1일부터 모든 경우를 브루트포스로 구해본다.
		dfs(1, 0);
		
		System.out.println(max);

	}

	private static void dfs(int day, int sum) {
		// 마지막 날까지 상담을 마친 경우, max 값을 갱신한다.
		if(day > N) {
			max = Math.max(max, sum);
			return;
		}
		
		int now = arr[day];
		int val = value[day];
		
		// 정해진 기한 내에 상담을 끝낼 수 있을 경우 상담 진행 후 계속해서 탐색한다.
		if(now + day <= N+1) {
			dfs(day+now, sum+val);
		}
		
		// 상담을 안하는 경우도 탐색한다.
		dfs(day+1, sum);
		
	}

}
