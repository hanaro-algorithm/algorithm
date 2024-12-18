import java.util.Scanner;

public class BOJ_S3_17626_FourSquares {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		int [] dp = new int[N+1];
		
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = 4;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);

	}
}
