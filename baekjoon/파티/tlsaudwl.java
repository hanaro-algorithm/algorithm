import java.util.*;

class Node implements Comparable<Node> {
    int vertex, cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class Main {
    static int N, M, X;
    static List<List<Node>> graph, reverseGraph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 학생 수 (노드 수)
        M = sc.nextInt(); // 도로 수 (간선 수)
        X = sc.nextInt(); // 목적지 마을 (파티 장소)

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Node(to, cost));
            reverseGraph.get(to).add(new Node(from, cost));
        }

        int[] toX = dijkstra(graph, X);
        int[] fromX = dijkstra(reverseGraph, X);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, toX[i] + fromX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.vertex;
            int nowCost = current.cost;

            if (nowCost > dist[now]) continue;

            for (Node next : graph.get(now)) {
                int newCost = nowCost + next.cost;
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.offer(new Node(next.vertex, newCost));
                }
            }
        }
        return dist;
    }
}
