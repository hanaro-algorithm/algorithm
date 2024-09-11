import java.util.Scanner;

public class BOJ_S3_9461_파도반수열 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = scann.nextInt();
		int [] nums = new int[T];
		
        // 매 테스트 케이스마다 dp 배열을 만들지 않고, 최대 길이만큼 생성하고 나머지 테케는 출력만 한다.
		int max = 0;
		
		for (int i = 0; i < T; i++) {
			int n = scann.nextInt();
			max = Math.max(max, n);
			nums[i] = n;
		}
		
		long [] dp;
		
		if(max <= 5) {
			dp = new long[6];
		} else {
			dp = new long[max+1];
		}
		
        // 1~5까지는 규칙이 성립하지 않는다.
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
        // i번째 삼각형의 길이는 i-1번째 삼각형과 i-5번째 삼각형 길이의 합이 된다.
		for (int i = 6; i <= max; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for (int i = 0; i < T; i++) {
			int n = nums[i];
			sb.append(dp[n]+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

}