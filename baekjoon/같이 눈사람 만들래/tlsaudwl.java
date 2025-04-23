import java.util.*;

public class Main {
    static class Pair {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] snow = new int[N];

        for (int i = 0; i < N; i++) {
            snow[i] = sc.nextInt();
        }

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(new Pair(i, j, snow[i] + snow[j]));
            }
        }

        list.sort(Comparator.comparingInt(p -> p.sum));

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            Pair a = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                Pair b = list.get(j);

                if (b.sum - a.sum >= min) break;

                if (a.i == b.i || a.i == b.j || a.j == b.i || a.j == b.j) continue;

                min = Math.min(min, Math.abs(a.sum - b.sum));
            }
        }

        System.out.println(min);
    }
}
