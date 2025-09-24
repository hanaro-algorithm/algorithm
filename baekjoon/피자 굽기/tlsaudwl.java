import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] oven = new int[D + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= D; i++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        int[] pizza = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        int depth = D;
        for (int i = 0; i < N; i++) {
            int size = pizza[i];

            while (depth > 0 && oven[depth] < size) {
                depth--;
            }

            if (depth == 0) {
                System.out.println(0);
                return;
            }

            depth--;
        }

        System.out.println(depth + 1);
    }
}
