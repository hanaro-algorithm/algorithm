import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = sc.nextInt();
        }

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][1] = people[node];

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }
}
