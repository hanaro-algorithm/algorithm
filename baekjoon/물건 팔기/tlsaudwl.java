import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[][] customers = new int[N][2];

        for (int i = 0; i < N; i++) {
            customers[i][0] = scan.nextInt();
            customers[i][1] = scan.nextInt();
        }


        Arrays.sort(customers, (a, b) -> Integer.compare(a[0], b[0]));

        int price = 0;
        int max = 0;


        for (int i = 0; i < N; i++) {
            int notPriceYet = customers[i][0];
            int total = 0;

            for (int j = i; j < N; j++) {
                int profit = notPriceYet - customers[j][1];
                if (profit > 0) {
                    total += profit;
                }
            }

            if (total > max || (total == max && notPriceYet < price)) {
                max = total;
                price = notPriceYet;
            }
        }

        System.out.println(max > 0 ? price : 0);
        scan.close();
    }
}
