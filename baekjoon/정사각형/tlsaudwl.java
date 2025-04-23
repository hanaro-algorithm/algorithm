import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] x = new int[4];
            int[] y = new int[4];

            for (int j = 0; j < 4; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
            }

            int[] distances = new int[6];
            int idx = 0;

            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    int dist = (x[j] - x[k]) * (x[j] - x[k]) + (y[j] - y[k]) * (y[j] - y[k]);
                    distances[idx++] = dist;
                }
            }

            Arrays.sort(distances);

            if (distances[0] == distances[1] &&
                    distances[1] == distances[2] &&
                    distances[2] == distances[3] &&
                    distances[4] == distances[5] &&
                    distances[0] != distances[4]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
