import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] players;         // 점수표
    static boolean[] selected;      // 방문여부
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
        // 팀 조합이 완성되면
        if (depth == N/2) {
            int startTeam = 0;
            int linkTeam = 0;

            for (int i = 0; i < N - 1; i++) {           // 방문한 팀과, 방문하지 않은 팀을 나누어, 각각의 시너지 값들 구하기
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {   // i, j 번째 사람이 true라면 startTeam에 +
                        startTeam += players[i][j];
                        startTeam += players[j][i];
                    } else if (!selected[i] && !selected[j]) {  // false라면 linkTeam에 +
                        linkTeam += players[i][j];
                        linkTeam += players[j][i];
                    }
                }
            }

            int diff = Math.abs(startTeam - linkTeam);  // 차이값
            answer = Math.min(answer, diff);            // 최솟값
            return;
        }
        for (int i = index; i < N; i++) {   // true, false로 팀 나누기
            // 만약 방문하지 않았다면,
            if (!selected[i]) {
                selected[i] = true;         // 방문으로 변경하고
                solve(depth + 1, i + 1);    // 재귀 호출
                selected[i] = false;        // 재귀 끝나면 방문 false로 바꿔주기
            }
        }
    }
}