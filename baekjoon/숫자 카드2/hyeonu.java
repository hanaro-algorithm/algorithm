import java.io.*;
import java.util.*;

//해쉬맵 -> 시간초과
//엄청 큰 배열 -> 풀리긴 하는데 메모리 너무 잡아먹음
//이분탐색
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬해놓고 마지막 - 첨 -> 개수
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int low = low(cards, num);
            int up = up(cards, num);
            sb.append(up - low).append(" ");
        }

        // 결과 출력
        System.out.println(sb);
    }

    // 첫 위치
    private static int low(int[] arr, int key) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= key) { // 더 작은 인덱스에서 찾기
                r = m;
            } else { // 더 큰 인덱스에서 찾기
                l = m + 1;
            }
        }
        return l;
    }

    // 마지막 위치(더 큰 수 첨 나타나는 위치)
    private static int up(int[] arr, int key) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > key) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
