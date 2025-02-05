import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] villages = new int[N][2];

        long totalPopulation = 0;

        for (int i = 0; i < N; i++) {
            villages[i][0] = sc.nextInt();
            villages[i][1] = sc.nextInt();
            totalPopulation += villages[i][1];
        }

        Arrays.sort(villages, Comparator.comparingInt(v -> v[0]));

        long populationSum = 0;
        for (int i = 0; i < N; i++) {
            populationSum += villages[i][1];
            if (populationSum >= (totalPopulation + 1) / 2) {
                System.out.println(villages[i][0]);
                break;
            }
        }
    }
}
