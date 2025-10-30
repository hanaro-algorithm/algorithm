import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int truthCount = sc.nextInt();
        int[] truth = new int[truthCount];
        for (int i = 0; i < truthCount; i++) truth[i] = sc.nextInt();

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < num; j++) list.add(sc.nextInt());
            parties.add(list);
            for (int j = 0; j < num - 1; j++) {
                union(list.get(j), list.get(j + 1));
            }
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int t : truth) {
            truthRoots.add(find(t));
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}
