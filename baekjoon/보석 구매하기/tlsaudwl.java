import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        long totalSum = 0;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long[] prefix = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + arr[i - 1];
            }

            long maxSum = Long.MIN_VALUE;
            int bestStart = 0, bestEnd = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    long sum = prefix[j + 1] - prefix[i];

                    int curLen = j - i + 1;
                    int bestLen = bestEnd - bestStart + 1;

                    if (sum > maxSum ||
                            (sum == maxSum && curLen < bestLen) ||
                            (sum == maxSum && curLen == bestLen && i < bestStart)) {
                        maxSum = sum;
                        bestStart = i;
                        bestEnd = j;
                    }
                }
            }

            totalSum += maxSum;
            sb.append(bestStart + 1).append(" ").append(bestEnd + 1).append("\n");
        }

        System.out.println(totalSum);
        System.out.print(sb.toString().trim());
    }
}
