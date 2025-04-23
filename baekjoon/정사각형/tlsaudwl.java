import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int[] x = new int[4];
            int[] y = new int[4];

            for (int j = 0; j < 4; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
            }

            List<Integer> distances = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    int dist = (x[j] - x[k]) * (x[j] - x[k]) + (y[j] - y[k]) * (y[j] - y[k]);
                    distances.add(dist);
                }
            }

            Collections.sort(distances);

            if (distances.get(0).equals(distances.get(1)) &&
                    distances.get(1).equals(distances.get(2)) &&
                    distances.get(2).equals(distances.get(3)) &&
                    distances.get(4).equals(distances.get(5)) &&
                    !distances.get(0).equals(distances.get(4))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        sc.close();
    }
}
