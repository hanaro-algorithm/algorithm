import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        int minWaitTime = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int I = sc.nextInt();
            int C = sc.nextInt(); 

            int lastBusTime = S + I * (C - 1);
            if (T > lastBusTime) continue; 

            if (T <= S) {
                minWaitTime = Math.min(minWaitTime, S - T);
            } else {
                int wait = ((T - S + I - 1) / I) * I + S - T;
                minWaitTime = Math.min(minWaitTime, wait);
            }
        }

        if (minWaitTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minWaitTime);
        }
    }
}
