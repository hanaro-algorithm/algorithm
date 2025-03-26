import java.util.*;

public class Main {
    static int[][] gears = new int[4][8]; // 4개의 톱니바퀴, 각 톱니바퀴는 8개의 칸을 가짐

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 톱니바퀴의 초기 상태 입력
        for (int i = 0; i < 4; i++) {
            String gear = sc.next();  // 톱니바퀴의 상태를 문자열로 받음
            for (int j = 0; j < 8; j++) {
                gears[i][j] = gear.charAt(j) - '0'; // 문자열에서 각 문자를 정수로 변환하여 저장
            }
        }

        int K = sc.nextInt();  // 회전 명령의 개수
        for (int i = 0; i < K; i++) {
            int gearNum = sc.nextInt() - 1;  // 회전할 톱니바퀴 번호 (0부터 시작)
            int direction = sc.nextInt();  // 회전 방향 (1: 시계방향, -1: 반시계방향)
            rotateGears(gearNum, direction);  // 톱니바퀴 회전
        }

        // 최종 톱니바퀴의 자석 상태 출력
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) {  // 각 톱니바퀴의 12시 방향이 자석이 있으면
                result += Math.pow(2, i);  // 자석이 있는 톱니바퀴의 번호에 해당하는 값을 더함
            }
        }

        System.out.println(result);
    }

    // 톱니바퀴 회전 함수
    static void rotateGears(int gearNum, int direction) {
        int[] directions = new int[4];  // 각 톱니바퀴의 회전 방향을 기록
        directions[gearNum] = direction;

        // 왼쪽 톱니바퀴들 회전 방향 설정
        for (int i = gearNum - 1; i >= 0; i--) {
            if (gears[i][2] != gears[i + 1][6]) {  // 현재 톱니바퀴와 오른쪽 톱니바퀴의 접점이 다르면
                directions[i] = -directions[i + 1];  // 반대 방향으로 회전
            } else {
                break;  // 접점이 같으면 회전을 멈춤
            }
        }

        // 오른쪽 톱니바퀴들 회전 방향 설정
        for (int i = gearNum + 1; i < 4; i++) {
            if (gears[i][6] != gears[i - 1][2]) {  // 현재 톱니바퀴와 왼쪽 톱니바퀴의 접점이 다르면
                directions[i] = -directions[i - 1];  // 반대 방향으로 회전
            } else {
                break;  // 접점이 같으면 회전을 멈춤
            }
        }

        // 각 톱니바퀴 회전
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) {  // 시계방향 회전
                rotateClockwise(i);
            } else if (directions[i] == -1) {  // 반시계방향 회전
                rotateCounterClockwise(i);
            }
        }
    }

    // 시계방향 회전
    static void rotateClockwise(int gearNum) {
        int temp = gears[gearNum][7];  // 마지막 칸을 저장
        for (int i = 7; i > 0; i--) {
            gears[gearNum][i] = gears[gearNum][i - 1];  // 오른쪽으로 한 칸씩 밀기
        }
        gears[gearNum][0] = temp;  // 마지막 칸을 첫 번째 칸에 넣기
    }

    // 반시계방향 회전
    static void rotateCounterClockwise(int gearNum) {
        int temp = gears[gearNum][0];  // 첫 번째 칸을 저장
        for (int i = 0; i < 7; i++) {
            gears[gearNum][i] = gears[gearNum][i + 1];  // 왼쪽으로 한 칸씩 밀기
        }
        gears[gearNum][7] = temp;  // 첫 번째 칸을 마지막 칸에 넣기
    }
}
