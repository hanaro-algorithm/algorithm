import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_21758_꿀따기 {
	static int N;
	static int [] honey, leftSum, rightSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		honey = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
		}
		
		leftSum = new int[N];
		leftSum[0] = honey[0];
		
		for (int i = 1; i < N; i++) {
			leftSum[i] = leftSum[i-1] + honey[i];
		}
		
		rightSum = new int[N];
		rightSum[N-1] = honey[N-1];
		
		for (int i = N-2; i >= 0; i--) {
			rightSum[i] = rightSum[i+1] + honey[i];
		}
		
		int left = findLeft();
		int right = findRight();
		int mid = findMid();
		
		System.out.println(Math.max(mid, Math.max(left, right)));
		
	}

	private static int findLeft() {
		int max = 0;
		
		for (int i = 1; i < N-1; i++) {
			int sum = leftSum[N-1]*2 - honey[0];
			sum -= (leftSum[i] + honey[i]);
			
			max = Math.max(max, sum);
		}
		
		return max;
	}

	private static int findRight() {
		int max = 0;
		
		for (int i = 1; i < N-1; i++) {
			int sum = rightSum[0]*2 - honey[N-1];
			sum -= (rightSum[i] + honey[i]);
			
			max = Math.max(max, sum);
		}
		
		return max;
	}

	private static int findMid() {
		int max = 0;
		
		for (int i = 1; i < N-1; i++) {
			int sum = 0;
			sum += leftSum[i] - honey[0];
			sum += rightSum[i] - honey[N-1];
			
			max = Math.max(max, sum);
		}
		
		return max;
	}

}
