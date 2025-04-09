import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] visitors = new int[n];
        for (int i = 0; i < n; i++) {
            visitors[i] = sc.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum += visitors[i];
        }

        int max = sum;
        int count = 1;

        for (int i = x; i < n; i++) {
            sum = sum - visitors[i - x] + visitors[i];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
