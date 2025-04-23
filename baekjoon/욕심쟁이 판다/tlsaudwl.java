import java.util.*;

public class Main {
    static int N;
    static int[][] forest, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        forest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                forest[i][j] = sc.nextInt();

        int max = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                max = Math.max(max, dfs(i, j));

        System.out.println(max);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (forest[nx][ny] > forest[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
