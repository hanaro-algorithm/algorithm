import java.util.*;
import java.io.*;

class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];




        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(0, 0);
        System.out.println(min);
    }

    static void bt(int sum, int cnt) {
        if (cnt == 3) {
            min = Math.min(min, sum);
            return;
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!check(i, j))
                    continue;
                bt(sum + seed(i, j), cnt + 1);
                clear(i, j);
            }
        }
    }

    // 4 dir check
    static boolean check(int r, int c) {
        if(visit[r][c])
            return false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n || visit[nr][nc])
                return false;
        }
        return true;
    }

    // seed
    static int seed(int r, int c) {
        int sum = map[r][c];
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            visit[nr][nc] = true;
            sum += map[nr][nc];
        }
        return sum;
    }

    static void clear(int r, int c) {
        visit[r][c] = false;
        for (int i = 0; i < 4; i++) {
            visit[r + dr[i]][c + dc[i]] = false;
        }
    }
}