import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_6236_용돈관리 {
	static int N, M;
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int left = max;
		int right = max*N;
		int ans = right;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(simul(mid)) {
				right = mid-1;
				ans = mid;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static boolean simul(int mid) {
		int money = mid;
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			money -= arr[i];
			
			if(money < 0) {
				money = mid - arr[i];
				cnt++;
			}
		}
		
		return cnt <= M;
	}

}
