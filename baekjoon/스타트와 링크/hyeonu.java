import java.util.*;
import java.io.*;

class Main {
    static int N, start, link, min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1]; // 1 부터
        team = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(1, 0);
        System.out.println(min);
    }

    static void bt(int idx, int cnt) {
        if (cnt == N / 2) { // 다 뽑히면 뽑힌 팀 기준으로 계산돌려봄
            calc();
            return;
        }

        for (int i = idx; i <= N; i++) {
            team[i] = true; // 뽑은 놈
            bt(i + 1, cnt + 1); // 뽑은 놈 그 담부터, 뽑은 수 증가
            team[i] = false; // 다음 재귀에 넣을때를 위해 초기화
        }
    }

    static void calc() {
        start = 0;
        link = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j)
                    continue;
                if(team[i] && team[j]) // i j 존재하면
                    start += S[i][j];
                if(!team[i] && !team[j]) // 나머지
                    link += S[i][j];
            }
        }
        min = Math.min(min, Math.abs(start - link)); // 최소차 없뎃
    }
}