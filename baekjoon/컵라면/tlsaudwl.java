import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] problems = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken()); // deadline
            problems[i][1] = Integer.parseInt(st.nextToken()); // ramen count
        }

        Arrays.sort(problems, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] problem : problems) {
            pq.offer(problem[1]);

            if (pq.size() > problem[0]) {
                pq.poll();
            }
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}
