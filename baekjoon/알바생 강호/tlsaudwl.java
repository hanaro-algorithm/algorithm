import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] tips = new Integer[n];

        for (int i = 0; i < n; i++) {
            tips[i] = sc.nextInt();
        }

        Arrays.sort(tips, Collections.reverseOrder());

        long total = 0;

        for (int i = 0; i < n; i++) {
            int tip = tips[i] - i;
            if (tip > 0) {
                total += tip;
            }
        }

        System.out.println(total);
    }
}
