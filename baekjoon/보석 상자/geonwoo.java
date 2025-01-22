import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2792_보석상자 {
	static int N, M;
	static int [] gems;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gems = new int[M];
		
		int max = 0;
		for (int i = 0; i < M; i++) {
			gems[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, gems[i]);
		}
		
		int left = 1;
		int right = max;
		int ans = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(check(mid)) {
				right = mid-1;
				ans = mid;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static boolean check(int mid) {
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			int gem = gems[i];
			int person = gem % mid == 0 ? gem/mid : gem/mid + 1;
			sum += person;
			
			if(sum > N) return false;
		}
		
		return true;
	}

}
