import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime;
    static int[][] visited;
    static Queue<int[]> fireQ, q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            visited = new int[h][w];
            fireQ = new LinkedList<>();
            q = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    fireTime[i][j] = -1;
                    visited[i][j] = -1;

                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireTime[i][j] = 0;
                    }

                    if (map[i][j] == '@') {
                        q.offer(new int[]{i, j});
                        visited[i][j] = 0;
                    }
                }
            }

            while (!fireQ.isEmpty()) {
                int[] cur = fireQ.poll();
                int x = cur[0], y = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (map[nx][ny] == '#' || fireTime[nx][ny] >= 0) continue;

                    fireTime[nx][ny] = fireTime[x][y] + 1;
                    fireQ.offer(new int[]{nx, ny});
                }
            }

            boolean escaped = false;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        System.out.println(visited[x][y] + 1);
                        escaped = true;
                        break;
                    }

                    if (map[nx][ny] == '#' || visited[nx][ny] >= 0) continue;
                    if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= visited[x][y] + 1) continue;

                    visited[nx][ny] = visited[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }

                if (escaped) break;
            }

            if (!escaped) System.out.println("IMPOSSIBLE");
        }
    }
}
