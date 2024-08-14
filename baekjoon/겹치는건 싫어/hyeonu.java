import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 최대 중복 개수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001]; // 범위가 1~100000 -> 1부터임
        // 두 포인터 둘 다 0부터 시작해서 r을 증가해가며 확장 방식
        int l = 0;
        int r = 0;
        int max = 0; // 최대 길이

        // 오른쪽 포인터 증가해가며 확장
        while (r < N) {
            cnt[arr[r]]++; // 현재 원소 빈도 증가

            // 빈도 K 초과 -> l을 증가시켜 축소
            while (cnt[arr[r]] > K) {
                cnt[arr[l]]--;
                l++;
            }

            // 최대값 갱신
            max = Math.max(max, r - l + 1);
            r++;
        }

        System.out.println(max);
    }
}
