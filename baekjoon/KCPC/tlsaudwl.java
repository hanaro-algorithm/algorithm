import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int t = scan.nextInt();
            int m = scan.nextInt();

            int[] totalScore = new int[n + 1];
            int[] count = new int[n + 1];
            int[] lastSubmit = new int[n + 1];
            int[][] maxScore = new int[n + 1][k + 1];

            for (int i = 0; i < m; i++) {
                int team = scan.nextInt();
                int problem = scan.nextInt();
                int score = scan.nextInt();

                count[team]++;
                lastSubmit[team] = i + 1;

                if (score > maxScore[team][problem]) {
                    totalScore[team] += score - maxScore[team][problem];
                    maxScore[team][problem] = score;
                }
            }

            List<int[]> rank = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                rank.add(new int[]{totalScore[i], count[i], lastSubmit[i], i});
            }

            rank.sort((a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            });

            for (int i = 0; i < rank.size(); i++) {
                if (rank.get(i)[3] == t) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
        scan.close();
    }
}