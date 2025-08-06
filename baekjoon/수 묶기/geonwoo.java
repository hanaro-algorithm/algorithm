import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {
	static int N;
	static int [] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(find(n)) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static boolean find(int n) {
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(nums[mid] < n) {
				left = mid + 1;
			} else if(nums[mid] > n) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}

}
