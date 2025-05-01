import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int minFuel = Integer.MAX_VALUE;

    public static void dfs(int row, int col, int fuel, int dir) { // dir (0, 1, 2)
        if (row == N) {
            minFuel = Math.min(minFuel, fuel);
            return;
        }

        for (int d = 0; d < 3; d++) {
            if (d == dir) continue;

            int newCol = col + (d - 1); // d=0→-1, d=1→0, d=2→+1

            if (newCol >= 0 && newCol < M) {
                dfs(row + 1, newCol, fuel + map[row][newCol], d);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for (int j = 0; j < M; j++) {
            dfs(1, j, map[0][j], -1);
        }

        System.out.println(minFuel);
    }
}
