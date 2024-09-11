import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 무게 오름차순으로 정렬
        Arrays.sort(arr);

        // 왼쪽, 오른쪽 포인터 초기화
        int l = 0;
        int r = N - 1;
        int cnt = 0; // 해피 수

        while (l < r) {
            // 두 포인터 합 K 안 넘어감 -> 해피 증가
            if (arr[l] + arr[r] <= K) {
                cnt++;
                l++;
                r--;
            } else {
                r--; // 무게 합이 K를 초과 -> 오른쪽 포인터 감소
            }
        }

        System.out.println(cnt);
    }
}
