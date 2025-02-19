import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MOD = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N == 1) {
            System.out.println(5);
            return;
        }

        long eat1 = 1, eat2 = 1, eat3 = 1, eat4 = 1, skip = 1;

        for (int day = 2; day <= N; day++) {
            long newEat1 = (eat3 + eat4 + skip) % MOD;
            long newEat2 = (eat4 + skip) % MOD;
            long newEat3 = (eat1 + skip) % MOD;
            long newEat4 = (eat1 + eat2 + skip) % MOD;
            long newSkip = (eat1 + eat2 + eat3 + eat4) % MOD;

            eat1 = newEat1;
            eat2 = newEat2;
            eat3 = newEat3;
            eat4 = newEat4;
            skip = newSkip;
        }

        long result = (eat1 + eat2 + eat3 + eat4 + skip) % MOD;

        System.out.println(result);
    }
}
