import java.util.Scanner;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

        if (S == 0) count--;

        System.out.println(count);
    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) count++;
            return;
        }

        dfs(depth + 1, sum + arr[depth]);

        dfs(depth + 1, sum);
    }
}
