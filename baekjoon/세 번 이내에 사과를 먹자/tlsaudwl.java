import java.util.*;

public class Main {
    static int[][] board = new int[5][5];
    static int maxApples = 0;

    static int[] dx = {-1, 1, 0, 0}; // 상하 이동
    static int[] dy = {0, 0, -1, 1}; // 좌우 이동

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        dfs(r, c, 0, 0);

        System.out.println(maxApples >= 2 ? 1 : 0);
    }

    static void dfs(int x, int y, int moves, int apples) {
        if (moves > 3) return;

        if (apples >= 2) {
            maxApples = Math.max(maxApples, apples);
            return;
        }

        int temp = board[x][y];
        board[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && board[nx][ny] != -1) {
                int newApples = apples;
                if (board[nx][ny] == 1) newApples++;
                dfs(nx, ny, moves + 1, newApples);
            }
        }

        board[x][y] = temp;
    }
}