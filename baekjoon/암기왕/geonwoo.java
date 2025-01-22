import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_2776_암기왕 {
	static int N;
	static int [] nums;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(biSearch(n)) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static boolean biSearch(int target) {
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int num = nums[mid];
			
			if(num == target) {
				return true;
			} else if(num > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return false;
	}

}
