import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static boolean[][] isVisited;
    static char[][] map;
    static int R;
    static int C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int sheepResult = 0;
    static int wolfResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j] && map[i][j] != '#') {
                    bfs(new Point(i, j));
                }
            }
        }

        System.out.println(sheepResult + " " + wolfResult);
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        isVisited[point.r][point.c] = true;

        int wolfCnt = 0;
        int sheepCnt = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int r = current.r;
            int c = current.c;

            if (map[r][c] == 'k') sheepCnt++;
            else if (map[r][c] == 'v') wolfCnt++;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !isVisited[nr][nc] && map[nr][nc] != '#') {
                    isVisited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
        }

        if (sheepCnt > wolfCnt) sheepResult += sheepCnt;
        else wolfResult += wolfCnt;
    }
    
}
