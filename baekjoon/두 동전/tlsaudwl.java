import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Coin {
        int x1, y1, x2, y2, cnt;
        Coin(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int[] coins = new int[4]; // x1, y1, x2, y2
        int idx = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') {
                    coins[idx++] = i;
                    coins[idx++] = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(coins[0], coins[1], coins[2], coins[3]));
    }

    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<Coin> q = new LinkedList<>();
        q.offer(new Coin(x1, y1, x2, y2, 0));
        visited[x1][y1][x2][y2] = true;

        while (!q.isEmpty()) {
            Coin c = q.poll();

            if (c.cnt >= 10) return -1;

            for (int dir = 0; dir < 4; dir++) {
                int nx1 = c.x1 + dx[dir];
                int ny1 = c.y1 + dy[dir];
                int nx2 = c.x2 + dx[dir];
                int ny2 = c.y2 + dy[dir];

                boolean out1 = isOut(nx1, ny1);
                boolean out2 = isOut(nx2, ny2);

                // 하나만 나간 경우 성공
                if (out1 ^ out2) return c.cnt + 1;

                // 둘 다 나간 경우 실패
                if (out1 && out2) continue;

                // 벽이면 이동 안 함
                if (!out1 && board[nx1][ny1] == '#') {
                    nx1 = c.x1;
                    ny1 = c.y1;
                }
                if (!out2 && board[nx2][ny2] == '#') {
                    nx2 = c.x2;
                    ny2 = c.y2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.offer(new Coin(nx1, ny1, nx2, ny2, c.cnt + 1));
                }
            }
        }
        return -1;
    }

    static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
