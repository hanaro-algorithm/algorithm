import java.io.*;
import java.util.*;

class Main {
    static int N, M, d, cnt = 0;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서 순서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(sr, sc);
        System.out.println(cnt);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = 2; // 현재 위치 청소
        cnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            boolean cleaned = false; // 청소 여부 체크

            for (int i = 0; i < 4; i++) { // 반시계 방향으로 회전하면서 확인
                d = (d + 3) % 4; // 반시계 방향으로 90도 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (map[nr][nc] == 0) { // 청소되지 않은 빈 칸 발견
                    map[nr][nc] = 2; // 청소
                    cnt++;
                    q.offer(new int[]{nr, nc});
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) { // 4방향 모두 청소되었거나 벽인 경우 후진
                int backDir = (d + 2) % 4; // 후진할 방향
                int nr = r + dr[backDir];
                int nc = c + dc[backDir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) { // 벽이 아니면 후진
                    q.offer(new int[]{nr, nc});
                } else { // 후진할 곳이 벽이면 종료
                    return;
                }
            }
        }
    }
}
