import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int num, int len) {
        if (len == N) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                dfs(next, len + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
