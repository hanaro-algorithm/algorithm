import java.util.*;
import java.io.*;

public class Main {
    static String T;
    static int N;
    static String[] titles;
    static int[] costs;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        N = Integer.parseInt(br.readLine());

        titles = new String[N];
        costs = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            costs[i] = Integer.parseInt(input[0]);
            titles[i] = input[1];
        }

        dfs(0, 0, new int[26]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // DFS로 조합 탐색
    static void dfs(int idx, int cost, int[] count) {
        if (idx == N) {
            if (canMakeTarget(count)) {
                answer = Math.min(answer, cost);
            }
            return;
        }

        dfs(idx + 1, cost, count);

        int[] newCount = count.clone();
        for (char c : titles[idx].toCharArray()) {
            newCount[c - 'A']++;
        }
        dfs(idx + 1, cost + costs[idx], newCount);
    }

    static boolean canMakeTarget(int[] count) {
        int[] targetCount = new int[26];
        for (char c : T.toCharArray()) {
            targetCount[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
