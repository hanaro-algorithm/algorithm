import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS 탐색 시작 (0,1)에서 시작, 초기 방향은 가로(0)
        dfs(0, 1, 0);
        System.out.println(count);
    }

    // x, y: 현재 파이프 끝 위치, dir: 현재 방향 (0: 가로, 1: 세로, 2: 대각선)
    static void dfs(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) { // 목표 지점 도착
            count++;
            return;
        }

        // 가로 이동
        if (dir == 0 || dir == 2) {
            if (y + 1 < N && map[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        }

        // 세로 이동
        if (dir == 1 || dir == 2) {
            if (x + 1 < N && map[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        }

        // 대각선 이동
        if (x + 1 < N && y + 1 < N) {
            if (map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                dfs(x + 1, y + 1, 2);
            }
        }
    }
}
