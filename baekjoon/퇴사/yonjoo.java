import java.io.*;
import java.util.*;

public class Main {

    int solution(int[][] arr){
        int[] dp = new int[arr.length + 1];

        for(int day = 0; day < arr.length; day++){
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);

            if(day + arr[day][0] <= arr.length){
                dp[day + arr[day][0]] = Math.max(dp[day + arr[day][0]], dp[day] + arr[day][1]);
            }
        }
        return dp[arr.length];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] in = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(in[0]);
            arr[i][1] = Integer.parseInt(in[1]);
        }
        System.out.println(T.solution(arr));
    }
}
