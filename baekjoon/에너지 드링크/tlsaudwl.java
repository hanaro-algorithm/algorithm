import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] drinks = new double[n];

        for (int i = 0; i < n; i++) {
            drinks[i] = sc.nextDouble();
        }

        Arrays.sort(drinks);

        double maxDrink = drinks[n - 1];

        for (int i = 0; i < n - 1; i++) {
            maxDrink = maxDrink + drinks[i] / 2;
        }

        System.out.println(maxDrink);
    }
}
