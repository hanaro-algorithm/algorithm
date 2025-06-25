import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N; i++) {
            combine(0, 0, i); 
        }

        System.out.println(minDiff);
    }

    static void combine(int index, int count, int teamSize) {
        if (count == teamSize) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }

            int diff = Math.abs(getAbility(start) - getAbility(link));
            minDiff = Math.min(minDiff, diff);
            return;
        }

        if (index >= N) return;

        selected[index] = true;
        combine(index + 1, count + 1, teamSize);

        selected[index] = false;
        combine(index + 1, count, teamSize);
    }

    static int getAbility(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i != j) {
                    int a = team.get(i);
                    int b = team.get(j);
                    sum += S[a][b];
                }
            }
        }
        return sum;
    }
}
