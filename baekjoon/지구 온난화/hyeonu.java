import java.util.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] map, res;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        res = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                res[i][j] = map[i][j];
            }
        }
        bfs();
        printRes();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (map[r][c] == 'X') {
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (!chk(nr, nc) || map[nr][nc] == '.')
                        cnt++;
                }

                if (cnt >= 3)
                    res[r][c] = '.';
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (chk(nr, nc) && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static boolean chk(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static void printRes() {
        int minR = R, maxR = 0, minC = C, maxC = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (res[i][j] == 'X') {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
