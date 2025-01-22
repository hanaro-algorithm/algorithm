import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2470_두용액 {
	static int N, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int ans1 = -1;
		int ans2 = -1;
		
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			int leftNum = arr[left];
			int rightNum = arr[right];
			int sum = leftNum + rightNum;
			
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans1 = leftNum;
				ans2 = rightNum;
			}
			
			if(sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		
		System.out.println(ans1+" "+ans2);
		
	}

}
