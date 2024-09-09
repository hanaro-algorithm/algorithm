import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] players;
    static boolean[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        players = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(answer);
        br.close();

    }
    static void solve(int depth, int index) {
        if (depth == N/2) {
            int startTeam = 0;
            int linkTeam = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        startTeam += players[i][j];
                        startTeam += players[j][i];
                    } else if (!selected[i] && !selected[j]) {
                        linkTeam += players[i][j];
                        linkTeam += players[j][i];
                    }
                }
            }

            int diff = Math.abs(startTeam - linkTeam);
            answer = Math.min(answer, diff);
            return;
        }
        for (int i = index; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                solve(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }
}