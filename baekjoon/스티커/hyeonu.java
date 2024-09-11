import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n];
            arr = new int[2][n];
            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(score(n));
        }
    }
    static int score(int n){
        if(n==1)
            return Math.max(arr[0][0], arr[1][0]);

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = dp[1][0] + arr[0][1];
        dp[1][1] = dp[0][0] + arr[1][1];

        for(int i = 2; i < n; i++){
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
