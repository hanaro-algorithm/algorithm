import java.util.Scanner;

public class Main {
    static long x;
    static long y;
    static int target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        target = (int) ((y * 100) / x);

        if (target >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 0;
        int right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int z = (int) (((y + mid) * 100) / (x + mid));

            if (target >= z) {
                result = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}