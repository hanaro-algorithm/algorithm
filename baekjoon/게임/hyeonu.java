import java.io.*;
import java.util.StringTokenizer;

//int로 했다가 범위 터짐 -> long
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 총 게임 수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        // 현재 승률 계산
        long Z = (Y * 100) / X;

        // 승률이 99% 이상이면 변하지 않음 -> -1
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long l = 1, r = 1_000_000_000; // 이분 탐색 범위
        long ans = -1;

        while (l <= r) {
            long m = (l + r) / 2; // 중간 값
            long newZ = ((Y + m) * 100) / (X + m); // 새로운 승률

            // 새로운 승률이 기존 승률보다 클 때
            if (newZ > Z) {
                ans = m; // 현재 m이 답이 될 수 있음
                r = m - 1; // 더 적은 게임 수를 찾기 위해 범위를 줄임
            } else {
                l = m + 1; // 승률이 아직 변하지 않으므로 범위를 늘림
            }
        }

        System.out.println(ans);
    }
}
