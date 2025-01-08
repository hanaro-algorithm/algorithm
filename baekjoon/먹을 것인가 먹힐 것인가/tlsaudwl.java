import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 크기
            int M = Integer.parseInt(st.nextToken()); // B의 크기

            int[] A = new int[N];
            int[] B = new int[M];

            // A 배열 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int count = 0;
            for (int a : A) {
                count += upperBound(B, a);
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }

    // upperBound: 주어진 값보다 작은 값의 개수를 반환
    private static int upperBound(int[] arr, int value) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
