import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int T = sc.nextInt();
            long[] countries = new long[T];

            for (int i = 0; i < T; i++) {
                countries[i] = sc.nextLong();
            }

            Arrays.sort(countries);

            long winner = countries[0];
            int maxCount = 1, count = 1;

            for (int i = 1; i < T; i++) {
                if (countries[i] == countries[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count > maxCount) {
                    maxCount = count;
                    winner = countries[i];
                }
            }

            if (maxCount > T / 2) {
                System.out.println(winner);
            } else {
                System.out.println("SYJKGW");
            }
        }
    }
}