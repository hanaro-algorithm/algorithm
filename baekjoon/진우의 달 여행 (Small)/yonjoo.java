import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][][] dp;
    static final int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < M; i++){
            int init = map[0][i];
            for(int j = 0; j < 3; j++){
                dp[0][i][j] = init;
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j == 0){ // 맨 왼쪽
                    // 오른쪽 빼고 다 ok
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];

                    // 왼쪽 불가(왼쪽 끝 벽이니까), 가운데 불가(직진했으면 또 직진 못하니까), 오른쪽만 가능
                    dp[i][j][1] = dp[i-1][0][0] + map[i][j];
                }
                else if(j == M - 1){ // 맨 오른쪽
                    dp[i][j][1] = dp[i-1][j][2] + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + map[i][j];
                }
                else{
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j]; // 0 빼고 다
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j]; // 1 빼고 다
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j]; // 2 빼고 다
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 3; j++){
                min = Math.min(dp[N-1][i][j], min);

            }
        }


        System.out.println(min);

    }
}