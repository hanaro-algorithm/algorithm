import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int score = sc.nextInt();
        int P = sc.nextInt();

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(sc.nextInt());
        }

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int rank = 1;
        for (int s : scores) {
            if (score < s) rank++;
            else break;
        }

        if (N == P && score <= scores.get(N - 1)) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}