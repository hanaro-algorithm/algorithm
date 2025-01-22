import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_2512_예산 {
	static int N;
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int right = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		int left = 1;
		int max = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int sum = cal(mid);
			if(sum <= max) {
				ans = Math.max(ans, mid);
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static int cal(int mid) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.min(arr[i], mid);
		}
		
		return sum;
	}

}
