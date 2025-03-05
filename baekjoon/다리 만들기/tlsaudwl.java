import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int minBridge = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬에 번호를 붙임 (BFS)
        int islandNum = 2;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    markIsland(i, j, islandNum);
                    islandNum++;
                }
            }
        }

        // 2. 각 섬에서 BFS 탐색을 시작하여 다리 길이 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) { // 섬이면
                    visited = new boolean[N][N];
                    findBridge(i, j, map[i][j]); // 섬 번호를 넘겨줌
                }
            }
        }

        System.out.println(minBridge);
    }

    // BFS로 섬을 찾고 번호를 매김
    static void markIsland(int x, int y, int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandNum;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = islandNum;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    // BFS로 가장 짧은 다리를 찾음
    static void findBridge(int x, int y, int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0}); // x, y, 거리
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) { // 바다인 경우 다리 확장
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    } else if (map[nx][ny] != islandNum) { // 다른 섬 도달
                        minBridge = Math.min(minBridge, dist);
                        return;
                    }
                }
            }
        }
    }
}
