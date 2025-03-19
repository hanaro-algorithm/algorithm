import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_5582_공통부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int N = str1.length();
		int M = str2.length();
		
		// dp[i][j]는 str1의 i번째 글자, str2의 j번째 글자까지 비교했을 때 가장 긴 공통 부분 문자열의 길이다.
		int [][] dp = new int[N+1][M+1];
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				char c1 = str1.charAt(i-1);
				char c2 = str2.charAt(j-1);
				
				// str1의 i번째 글자와 str2의 j번째 글자가 같다면 dp[i-1][j-1]에서 +1 해준다.
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
		
	}

}
