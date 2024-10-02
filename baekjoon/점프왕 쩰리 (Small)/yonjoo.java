import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    private void solution(int N, int[][] array){

        if (DFS(0, 0)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }

    }

    private static boolean DFS(int y, int x) {
        if (arr[y][x] == -1) {
            return true;
        }

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d] * arr[y][x];
            int ny = y + dy[d] * arr[y][x];

            if (nx >= N || ny >= N || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            if (DFS(ny, nx)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(N, arr);
    }
}
