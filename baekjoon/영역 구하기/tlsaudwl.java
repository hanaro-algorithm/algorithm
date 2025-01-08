import java.util.*;

public class Main {
    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt(); // 세로 길이
        int N = scanner.nextInt(); // 가로 길이
        int K = scanner.nextInt(); // 직사각형 개수

        int[][] board = new int[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            // 직사각형 내부를 1로 채우기
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    board[y][x] = 1; // 직사각형 내부
                }
            }
        }

        boolean[][] visited = new boolean[M][N];
        List<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y][x] == 0 && !visited[y][x]) {
                    int area = bfs(board, visited, x, y, M, N);
                    areas.add(area);
                }
            }
        }

        System.out.println(areas.size());
        Collections.sort(areas);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int[][] board, boolean[][] visited, int startX, int startY, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startY][startX] = true;

        int area = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[ny][nx] && board[ny][nx] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }

        return area;
    }
}
