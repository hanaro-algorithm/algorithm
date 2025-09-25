import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladder[a][b] = true;
        }

        dfs(0, 1, 1);
        System.out.println(answer == 4 ? -1 : answer);
    }

    static void dfs(int count, int startRow, int startCol) {
        if (count >= answer) return;
        if (check()) {
            answer = count;
            return;
        }
        if (count == 3) return;

        for (int i = startRow; i <= H; i++) {
            for (int j = (i == startRow ? startCol : 1); j < N; j++) {
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;
                ladder[i][j] = true;
                dfs(count + 1, i, j);
                ladder[i][j] = false;
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][pos]) pos++;
                else if (ladder[j][pos - 1]) pos--;
            }
            if (pos != i) return false;
        }
        return true;
    }
}
