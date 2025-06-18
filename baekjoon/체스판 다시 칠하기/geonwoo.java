import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		
		char [][] arr = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		outer:
			for (int k = 0; k <= N-8; k++) {
				for (int l = 0; l <= M-8; l++) {
					int white = 0;
					int black = 0;
					
					for (int i = k; i < k+8; i++) {
						for (int j = l; j < l+8; j++) {
							char c = arr[i][j];
							
							if((i+j) % 2 == 0) {
								if(c == 'W') black++;
								else white++;
							} else {
								if(c == 'W') white++;
								else black++;
							}
						}
					}
					
					ans = Math.min(ans, Math.min(black, white));
					
					if(ans == 0) break outer;
					
				}
			}
		
		System.out.println(ans);
		
	}

}
