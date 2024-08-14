import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        // 수열을 오름차순으로 정렬
        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int cnt = 0;

        // 두 포인터를 사용하여 쌍의 개수를 찾기
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == x) { // 합이 같다 카운트
                cnt++;
                l++;
                r--;
            } else if (sum < x) { // 합이 작다 -> 왼쪽 증가
                l++;
            } else { // 합이 크다 -> 오른쪽 감소
                r--;
            }
        }
        System.out.println(cnt);
    }
}
