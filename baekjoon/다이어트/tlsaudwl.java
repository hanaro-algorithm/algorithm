import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long G = sc.nextLong();

        List<Long> result = new ArrayList<>();

        for (long a = 1; a * a < G; a++) {
            if (G % a == 0) {
                long b = G / a;

                if ((a + b) % 2 == 0) {
                    long x = (a + b) / 2;
                    long y = (b - a) / 2;

                    if (y > 0) result.add(x);
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (long x : result) {
                System.out.println(x);
            }
        }
    }
}
