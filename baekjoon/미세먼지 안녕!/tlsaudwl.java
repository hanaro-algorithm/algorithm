import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[][] tempMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int airCleanerTop = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1 && airCleanerTop == -1) {
                    airCleanerTop = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spreadDust();
            runAirCleaner();
        }

        System.out.println(getDustSum());
    }

    static void spreadDust() {
        tempMap = new int[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    int amount = map[x][y] / 5;
                    int count = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1) {
                            tempMap[nx][ny] += amount;
                            count++;
                        }
                    }
                    map[x][y] -= amount * count;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
    }

    static void runAirCleaner() {
        int bottom = airCleanerTop + 1;

        // 위쪽 - 반시계 방향
        for (int i = airCleanerTop - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < airCleanerTop; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[airCleanerTop][i] = map[airCleanerTop][i - 1];
        map[airCleanerTop][1] = 0;

        // 아래쪽 - 시계 방향
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }

    static int getDustSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        return sum;
    }
}
