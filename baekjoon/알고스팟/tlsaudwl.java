import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int x, y, breakCount;

        Point(int y, int x, int breakCount) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                visited[i][j] = -1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        visited[0][0] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                // 범위 안에 있고
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    int nextBreak = now.breakCount + map[ny][nx]; // 벽이면 +1

                    // 아직 안 갔거나, 더 적은 벽으로 갈 수 있으면
                    if (visited[ny][nx] == -1 || visited[ny][nx] > nextBreak) {
                        visited[ny][nx] = nextBreak;
                        q.add(new Point(ny, nx, nextBreak));
                    }
                }
            }
        }

        System.out.println(visited[N - 1][M - 1]);
    }
}
