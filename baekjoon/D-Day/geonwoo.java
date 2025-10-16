import java.util.Scanner;

public class BOJ_S5_1308_DDay {
	static final int [] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        int y1 = scann.nextInt();
        int m1 = scann.nextInt();
        int d1 = scann.nextInt();
        int y2 = scann.nextInt();
        int m2 = scann.nextInt();
        int d2 = scann.nextInt();

        int total1 = calDay(y1, m1, d1);
        int total2 = calDay(y2, m2, d2);
        
        if(y2 - y1 > 1000 || y2 - y1 == 1000 && (m1 < m2 || m1 == m2 && d1 <= d2)) System.out.println("gg");
        else System.out.println("D-" + (total2 - total1));
    }

    static int calDay(int y, int m, int d) {
        int days = 0;

        for(int i = 1; i < y; i++) {
            days += 365 + checkYear(i);
        }

        for(int i = 1; i < m; i++) {
            if(i == 2) days += checkYear(y);
            days += day[i];
        }

        days += d;

        return days;
    }

    static int checkYear(int y) {
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}