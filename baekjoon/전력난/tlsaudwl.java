import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            if (m == 0 && n == 0) break;

            int[][] edges = new int[n][3];
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
                totalCost += edges[i][2];
            }

            Arrays.sort(edges, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int mstCost = 0;
            for (int i = 0; i < n; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                int cost = edges[i][2];

                if (find(from) != find(to)) {
                    union(from, to);
                    mstCost += cost;
                }
            }

            System.out.println(totalCost - mstCost);
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
            parent[rootB] = rootA;
    }

}
