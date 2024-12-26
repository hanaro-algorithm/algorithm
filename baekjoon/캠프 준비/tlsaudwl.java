import java.util.*;

public class Main {
    static int n, l, r, x;
    static int[] arr;

    public static void backtrack(int idx, int sum, int product, int min, int max, int count) {
        if (count >= 2 && sum >= l && sum <= r && max - min >= x) {
            countAnswer++;
        }

        for (int i = idx; i < n; i++) {
            backtrack(i + 1, sum + arr[i], product * arr[i], Math.min(min, arr[i]), Math.max(max, arr[i]), count + 1);
        }
    }

    static int countAnswer = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();   // 문제 개수
        l = scan.nextInt();   // 문제 난이도 합 최소
        r = scan.nextInt();   // 문제 난이도 합 최대
        x = scan.nextInt();   // 문제 난이도 최소 차이

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        backtrack(0, 0, 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        System.out.println(countAnswer);
    }
}
