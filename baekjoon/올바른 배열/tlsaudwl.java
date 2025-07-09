import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 4;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int end = arr[i] + 4;

            for (int j = i; j < n; j++) {
                if (arr[j] <= end) {
                    cnt++;
                } else {
                    break;
                }
            }

            answer = Math.min(answer, 5 - cnt);
        }

        System.out.println(answer);
    }
}
