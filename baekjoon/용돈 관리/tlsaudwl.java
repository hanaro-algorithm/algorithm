import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] expenses = new int[N];
        int maxExpense = 0, sumExpense = 0;

        for (int i = 0; i < N; i++) {
            expenses[i] = Integer.parseInt(br.readLine());
            maxExpense = Math.max(maxExpense, expenses[i]);
            sumExpense += expenses[i];
        }

        // 이분 탐색
        int left = maxExpense, right = sumExpense, answer = sumExpense;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(expenses, N, M, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isValid(int[] expenses, int N, int M, int K) {
        int count = 1;
        int currentMoney = K;

        for (int i = 0; i < N; i++) {
            if (currentMoney < expenses[i]) {
                count++;
                currentMoney = K;
            }
            currentMoney -= expenses[i];

            if (count > M) return false;
        }
        return true;
    }
}
