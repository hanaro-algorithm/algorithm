import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(line[j]);
                if (i < j) {
                    list.add(new int[] { i, j, cost });
                }
            }
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        long total = 0;

        for (int i = 0; i < list.size(); i++) {
            int[] edge = list.get(i);
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(a) != find(b)) {
                connect(a, b);
                total += cost;
            }
        }

        System.out.println(total);
    }

    // 부모 찾기 (서로 연결됐는지 확인)
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    // 연결하기 (같은 그룹으로 만들기)
    static void connect(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}
