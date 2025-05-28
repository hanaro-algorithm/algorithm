import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();

        int[][] exams = new int[N][2];

        for (int i = 0; i < N; i++) {
            exams[i][0] = sc.nextInt();
            exams[i][1] = sc.nextInt();
        }

        Arrays.sort(exams, Comparator.comparingInt(a -> a[0]));

        int nowTime = 0;

        for (int i = 0; i < N; i++) {
            int start = exams[i][0];
            int duration = exams[i][1];

            // 현재 시간부터 다음 시험 시작 전까지
            if (start - nowTime >= M) {
                System.out.println(nowTime);
                return;
            }

            nowTime = start + duration;
        }

        // 마지막 시험 이후
        if (S - nowTime >= M) {
            System.out.println(nowTime);
        } else {
            System.out.println(-1);
        }
    }
}
