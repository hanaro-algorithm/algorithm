import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_11066_파일합치기 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
        	int K = Integer.parseInt(br.readLine());
            int [] file = new int[K+1];
            int [][] dp = new int[K+1][K+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            file[1] = Integer.parseInt(st.nextToken());
            
            for(int i = 2; i <= K; i++) {
            	int n = Integer.parseInt(st.nextToken());
                file[i] = file[i-1] + n;
            }

            for (int i = 1; i < K; i++) {
                for (int head = 1; head+i <= K; head++) {
                    int tail = head + i;
                    
                    dp[head][tail] = Integer.MAX_VALUE;

                    for (int mid = head; mid < tail; mid++) {
                        dp[head][tail] = Math.min(dp[head][tail], dp[head][mid]+dp[mid+1][tail]+file[tail] - file[head-1]);
                    }
                }
            }
            
            System.out.println(dp[1][K]);
            
        }
    }
}