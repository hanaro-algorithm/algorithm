import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지방 수
        int[] budgets = new int[N];
        int maxBudget = 0;

        for (int i = 0; i < N; i++) {
            budgets[i] = sc.nextInt();
            maxBudget = Math.max(maxBudget, budgets[i]);
        }
        int M = sc.nextInt(); // 총 예산

        int left = 0;
        int right = maxBudget;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long total = 0;
            for (int budget : budgets) {
                total = total + Math.min(budget, mid);
            }

            if (total <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
