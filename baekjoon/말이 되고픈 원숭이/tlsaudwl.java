import java.util.*;
import java.io.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    // 일반 이동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 말처럼 이동
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    // 위치, 이동횟수, 말처럼 간 횟수
    static class Node {
        int x, y, move, horse;

        Node(int x, int y, int move, int horse) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.horse = horse;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];    // H행 W열
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == W - 1 && cur.y == H - 1) return cur.move;

            // 일반 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][cur.horse]) {
                        visited[ny][nx][cur.horse] = true;
                        queue.offer(new Node(nx, ny, cur.move + 1, cur.horse));
                    }
                }
            }

            // 말처럼 이동
            if (cur.horse < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];

                    if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                        if (map[ny][nx] == 0 && !visited[ny][nx][cur.horse + 1]) {
                            visited[ny][nx][cur.horse + 1] = true;
                            queue.offer(new Node(nx, ny, cur.move + 1, cur.horse + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
