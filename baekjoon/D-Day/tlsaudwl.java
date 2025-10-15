import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        LocalDate today = LocalDate.of(y1, m1, d1);
        LocalDate dday = LocalDate.of(y2, m2, d2);

        long diff = ChronoUnit.DAYS.between(today, dday);

        if (diff >= 365243) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + diff);
        }
    }
}
