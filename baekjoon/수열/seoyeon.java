import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 전체 날짜 수
        int k = Integer.parseInt(st.nextToken());   // 합을 구하기 위한 연속적인 날짜 수
        int[] temp = new int[n];    // 온도 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            temp[i] = Integer.parseInt(st.nextToken());  // 온도 입력받아서 저장
        }

        for(int i = 0; i < k; i++){ //일단 0~k까지 온도구간 먼저 더하고 max로
            max = max + temp[i];
        }

        int sum = max;  // 구간 온도의 합
        for(int i = k; i < n; i++){
            sum = sum - temp[i - k] + temp[i];  // 1번째 ~ k번째 온도구간 : 0부터 k 온도 구간 - 0번째 + k 번째
            max = Math.max(max, sum); // 더 큰 수
        }

        System.out.println(max);
    }
}