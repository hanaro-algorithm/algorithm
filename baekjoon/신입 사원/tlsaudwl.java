import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            int count = 1;
            int minInterview = scores[0][1];

            for (int i = 1; i < N; i++) {
                if (scores[i][1] < minInterview) {
                    count++;
                    minInterview = scores[i][1];
                }
            }

            System.out.println(count);
        }
    }
}
