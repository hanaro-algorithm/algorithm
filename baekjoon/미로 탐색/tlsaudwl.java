import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자 '1'을 숫자 1로 변환
            }
        }

        System.out.println(bfs(0, 0)); // (0,0)부터 시작
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            // 도착 지점에 도달하면 거리 반환
            if (curX == N - 1 && curY == M - 1) {
                return maze[curX][curY];
            }

            // 4방향 탐색 (상, 하, 좌, 우)
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위 체크 & 방문 여부 체크 & 이동 가능 여부 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[curX][curY] + 1; // 이동 거리 저장
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
