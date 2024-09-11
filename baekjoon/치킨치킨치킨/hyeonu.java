import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // 선호도 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        // 3가지 조합 다 돌려봄
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    int cur = 0;

                    // 각 회원에 대해 최대 선호도를 계산(n -> 회원)
                    for (int n = 0; n < N; n++) {
                        cur += Math.max(arr[n][i], Math.max(arr[n][j], arr[n][k]));
                    }
                    // 최댓값 갱신
                    max = Math.max(max, cur);
                }
            }
        }
        System.out.println(max);
    }
}
