import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int adjNode = Integer.parseInt(st.nextToken());
                if (adjNode == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(adjNode, weight));
            }
        }

        // 첫 번째 DFS 실행 (임의의 점에서 가장 먼 점 찾기)
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 두 번째 DFS 실행 (가장 먼 점에서 다시 DFS 실행하여 지름 찾기)
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        if (visited[node]) return;
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node next : tree[node]) {
            dfs(next.to, distance + next.weight);
        }
    }

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
