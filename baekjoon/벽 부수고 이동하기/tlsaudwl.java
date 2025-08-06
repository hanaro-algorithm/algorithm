import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, breakWall, distance;

        Node(int x, int y, int breakWall, int distance) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
            this.distance = distance;
        }
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.x == N - 1 && curr.y == M - 1) {
                return curr.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][curr.breakWall]) {
                    visited[nx][ny][curr.breakWall] = true;
                    q.add(new Node(nx, ny, curr.breakWall, curr.distance + 1));
                }

                else if (map[nx][ny] == 1 && curr.breakWall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.add(new Node(nx, ny, 1, curr.distance + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
