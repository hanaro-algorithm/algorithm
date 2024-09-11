import java.util.*;
import java.io.*;

class Main {
    static int N, max = Integer.MIN_VALUE;
    static int[] T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, 0);
        System.out.println(max);
    }

    static void dfs(int idx, int sum) {
        if (idx == N + 1) {
            max = Math.max(max, sum);
            return;
        }
        if (idx > N) {
            return;
        }
        if (idx + T[idx] <= N + 1) { // 그 날 상담 진행
            dfs(idx + T[idx], sum + P[idx]);
        }
        dfs(idx + 1, sum); // 오늘 상담 스킵 -> 내일
    }
}
