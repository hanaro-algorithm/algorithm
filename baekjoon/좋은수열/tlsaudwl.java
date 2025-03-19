import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        dfs("");
    }

    static void dfs(String seq) {
        if (seq.length() == N) {
            System.out.println(seq);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(seq + i)) {
                dfs(seq + i);
            }
        }
    }

    static boolean isGood(String seq) {
        int len = seq.length();

        for (int i = 1; i <= len / 2; i++) {
            String last = seq.substring(len - i);
            String beforeLast = seq.substring(len - 2 * i, len - i);

            if (last.equals(beforeLast)) {
                return false;
            }
        }
        return true;
    }
}
