import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input.split(" ")[0]);
        m = Integer.parseInt(input.split(" ")[1]);
        int k = Integer.parseInt(input.split(" ")[2]);
        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            input = br.readLine();
            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);

            arr[x][y] = 1;
        }

        int max = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }

            }
        }
        System.out.println(max);
    }

    private static void dfs(int a, int b) {
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x > -1 && y > -1 && x < n + 1 && y < m + 1 &&
                    arr[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                cnt++;
                dfs(x, y);
            }
        }
    }

}