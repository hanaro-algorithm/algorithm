import java.io.*;
import java.util.*;

public class Main {

    int solution(int[][] arr){
        int answer = 0;
        int LEN = arr[0].length;

        int[][] dp = new int[2][LEN];

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];

        if(LEN > 1) {
            dp[0][1] = arr[0][1] + dp[1][0];
            dp[1][1] = arr[1][1] + dp[0][0];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 2; i < LEN; i++){
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        answer = max;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Test = Integer.parseInt(br.readLine());
        for(int i = 0; i < Test; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; st.hasMoreTokens(); j++){
                arr[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; st.hasMoreTokens(); j++){
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            sb.append(T.solution(arr) + "\n");
        }

        System.out.println(sb.toString());
    }
}
