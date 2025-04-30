import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] honey = new int[N];
        int[] prefix = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        honey[0] = Integer.parseInt(st.nextToken());
        prefix[0] = honey[0];
        for (int i = 1; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + honey[i];
        }

        int max = 0;

        // 벌1 맨 왼쪽, 벌2는 중간, 꿀통은 맨 오른쪽
        for (int i = 1; i < N - 1; i++) {
            int bee1 = prefix[N - 1] - prefix[0]; // 왼쪽 벌 (index 0) ~ 끝까지, 자기 자리 제외
            int bee2 = prefix[N - 1] - prefix[i]; // 중간 벌 ~ 끝까지, 자기 자리 제외
            int result = bee1 + bee2 - honey[i]; // 중복 제거
            max = Math.max(max, result);
        }

        // 벌1 맨 오른쪽, 벌2는 중간, 꿀통은 맨 왼쪽
        for (int i = 1; i < N - 1; i++) {
            int bee1 = prefix[N - 2]; // 오른쪽 벌 (index N-1) ~ 왼쪽, 자기 자리 제외
            int bee2 = prefix[i - 1]; // 중간 벌 ~ 왼쪽, 자기 자리 제외
            int result = bee1 + bee2 - honey[i];
            max = Math.max(max, result);
        }

        // 꿀통은 중간, 벌1은 왼쪽 끝, 벌2는 오른쪽 끝
        for (int i = 1; i < N - 1; i++) {
            int bee1 = prefix[i] - honey[0]; // 왼쪽 벌 ~ 꿀통까지 (자기 자리 제외)
            int bee2 = (prefix[N - 1] - prefix[i - 1]) - honey[N - 1]; // 오른쪽 벌 ~ 꿀통까지
            int result = bee1 + bee2;
            max = Math.max(max, result);
        }

        System.out.println(max);
    }
}
