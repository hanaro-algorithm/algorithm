import java.util.*;

public class KnightMove7562_blog {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}; // 8방향 탐색
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int t;
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i< t; i++) {
            n = sc.nextInt();
            map = new int[n][n];

            int beginX = sc.nextInt();
            int beginY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            BFS(beginX, beginY);
            System.out.println(map[endX][endY] - 1);
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        map[x][y] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int i=0; i<dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nexY = current[1] + dy[i];

                if (nextX < 0 || nextX >= n || nexY < 0 || nexY >= n) continue;
                if (map[nextX][nexY] > 0) continue;

                q.offer(new int[] {nextX, nexY});
                map[nextX][nexY] = map[current[0]][current[1]] + 1;
            }
        }
    }
}