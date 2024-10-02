import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static int M;
    static int[][] dp = new int[11][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i = 1; i <= M; i++){    // N이 한 가지일 때 M개를 훔칠 수 있는 방법은 다 1
            dp[1][i] = 1;
        }
        for(int i = 1; i <= N; i++){    // N이 i 가지일 때 i 개를 훔칠 수 있는 방법도 1
            dp[i][i] = 1;
        }
        for(int i = 2; i <= N; i++){    // N이 2 가지부터 N 가지일 때,
            for(int j = i; j <= M; j++){    // 2 가지부터 M 가지를 훔칠 수 있는 방법
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];  // n이 행이고 m이 열
            }
        }
        System.out.println(dp[N][M]);
    }
}