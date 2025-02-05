import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 카데인 알고리즘
            int maxSum = arr[0];
            int currentSum = arr[0];

            for (int i = 1; i < N; i++) {
                currentSum = Math.max(arr[i], currentSum + arr[i]);
                maxSum = Math.max(maxSum, currentSum);
            }

            sb.append(maxSum).append("\n");
        }

        System.out.print(sb);
    }
}
