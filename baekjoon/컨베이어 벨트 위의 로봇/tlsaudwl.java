import java.util.*;

public class Main {
    static int N, K;
    static int[] nagudo;
    static boolean[] robot;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        nagudo = new int[2 * N];
        robot = new boolean[N];

        for (int i = 0; i < 2 * N; i++) {
            nagudo[i] = sc.nextInt();
        }

        int step = 0;

        while (true) {
            step++;

            rotateBelt();
            moveRobot();
            loadRobot();

            if (countZeroNagudo() >= K) {
                break;
            }
        }

        System.out.println(step);
    }

    // 벨트 회전
    static void rotateBelt() {
        int last = nagudo[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            nagudo[i] = nagudo[i - 1];
        }
        nagudo[0] = last;

        // 로봇도 오른쪽으로 이동
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    // 로봇 이동
    static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && nagudo[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                nagudo[i + 1]--;

                if (i + 1 == N - 1) {
                    robot[i + 1] = false;
                }
            }
        }
    }

    // 로봇 올리기
    static void loadRobot() {
        if (!robot[0] && nagudo[0] > 0) {
            robot[0] = true;
            nagudo[0]--;
        }
    }

    // 내구도 0인 칸 수 세기
    static int countZeroNagudo() {
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (nagudo[i] == 0) count++;
        }
        return count;
    }
}
