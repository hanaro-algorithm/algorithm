import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Long.parseLong(st.nextToken());

        if (N <= 2) {
            System.out.println(0);
            return;
        }

        int answer = N - 1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long diff = A[j] - A[i];
                int len = j - i;

                if (diff % len != 0) continue;

                long d = diff / len;
                long start = A[i] - i * d;

                int same = 0;
                for (int k = 0; k < N; k++) {
                    if (A[k] == start + k * d) same++;
                }
                answer = Math.min(answer, N - same);
            }
        }

        System.out.println(answer);
    }
}
