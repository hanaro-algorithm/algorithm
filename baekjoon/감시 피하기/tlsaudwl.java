import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> spaces = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.next().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j] == 'X') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        // 빈 칸 3개 조합 만들기
        combination(0, 0);

        System.out.println(found ? "YES" : "NO");
    }

    // 백트래킹으로 3개 장애물 설치
    static void combination(int depth, int start) {
        if (depth == 3) {
            if (isSafe()) {
                found = true;
            }
            return;
        }

        for (int i = start; i < spaces.size(); i++) {
            int[] pos = spaces.get(i);
            map[pos[0]][pos[1]] = 'O'; // 장애물 설치
            combination(depth + 1, i + 1);
            map[pos[0]][pos[1]] = 'X'; // 원상복구
        }
    }

    // 선생 감시 체크
    static boolean isSafe() {
        for (int[] t : teachers) {
            int x = t[0];
            int y = t[1];

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if (map[nx][ny] == 'O') break; // 장애물이 막음
                    if (map[nx][ny] == 'S') return false; // 학생 발견
                }
            }
        }
        return true;
    }
}
