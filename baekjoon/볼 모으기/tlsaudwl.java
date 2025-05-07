import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String balls = sc.nextLine();

        int result = Math.min(
                Math.min(moveCount(balls, 'R', true), moveCount(balls, 'R', false)),
                Math.min(moveCount(balls, 'B', true), moveCount(balls, 'B', false))
        );

        System.out.println(result);
    }

    static int moveCount(String balls, char color, boolean toLeft) {
        int count = 0;
        int n = balls.length();

        if (toLeft) {
            int idx = 0;
            while (idx < n && balls.charAt(idx) == color) {
                idx++;
            }
            for (int i = idx; i < n; i++) {
                if (balls.charAt(i) == color) {
                    count++;
                }
            }
        } else {
            int idx = n - 1;
            while (idx >= 0 && balls.charAt(idx) == color) {
                idx--;
            }
            for (int i = 0; i <= idx; i++) {
                if (balls.charAt(i) == color) {
                    count++;
                }
            }
        }

        return count;
    }
}
