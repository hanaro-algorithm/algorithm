import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int min = 64;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, count(board, i, j));
            }
        }

        System.out.println(min);
    }

    public static int count(char[][] board, int x, int y) {
        int countW = 0;
        int countB = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') countW++;
                    if (board[i][j] != 'B') countB++;
                } else {
                    if (board[i][j] != 'B') countW++;
                    if (board[i][j] != 'W') countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }
}
