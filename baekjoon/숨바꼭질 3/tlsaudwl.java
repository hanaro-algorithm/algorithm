import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == K) {
                System.out.println(dist[now]);
                return;
            }

            // 순간이동
            int teleport = now * 2;
            if (teleport <= MAX && dist[teleport] == -1) {
                dist[teleport] = dist[now];
                dq.offerFirst(teleport);
            }

            // 한 칸 뒤로
            int back = now - 1;
            if (back >= 0 && dist[back] == -1) {
                dist[back] = dist[now] + 1;
                dq.offerLast(back);
            }

            // 한 칸 앞으로
            int front = now + 1;
            if (front <= MAX && dist[front] == -1) {
                dist[front] = dist[now] + 1;
                dq.offerLast(front);
            }
        }
    }
}
