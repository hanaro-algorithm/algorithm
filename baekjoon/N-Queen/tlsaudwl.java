import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;   // 퀸을 놓을 수 있는 경우의 수
    static int[] board;     // 각 행에 퀸의 열 위치를 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];

        solve(0); // 첫 번째 행부터 퀸을 배치
        System.out.println(count);
    }

    // 행(row)에 퀸을 배치하는 함수
    static void solve(int row) {
        if (row == N) { // N개의 퀸을 모두 배치한 경우
            count++;
            return;
        }

        for (int col = 0; col < N; col++) { // 각 열에 퀸을 놓아본다
            if (isSafe(row, col)) {        // 퀸을 놓을 수 있는 위치인지 확인
                board[row] = col;         // 현재 행(row)의 열(col)에 퀸을 배치
                solve(row + 1);           // 다음 행으로 이동
            }
        }
    }

    // 현재 (row, col)에 퀸을 놓아도 되는지 확인하는 함수
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 다른 퀸이 있는지 또는 대각선에 다른 퀸이 있는지 확인
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false; // 놓을 수 없는 위치
            }
        }
        return true; // 놓아도 안전한 위치
    }
}
