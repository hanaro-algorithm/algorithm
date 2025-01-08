import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for (int t = 0; t < K; t++) {
            int V = sc.nextInt(); // 정점의 개수
            int E = sc.nextInt(); // 간선의 개수

            // 그래프를 인접 리스트로 표현
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 방문 및 색상 배열 (-1: 방문하지 않음, 0: 빨강, 1: 파랑)
            int[] color = new int[V + 1];
            Arrays.fill(color, -1);

            boolean isBipartite = true; // 이분 그래프 여부 판단

            // 모든 노드에서 BFS 시작 (그래프가 여러 컴포넌트로 이루어질 수 있음)
            for (int i = 1; i <= V; i++) {
                if (color[i] == -1) { // 방문하지 않은 노드만 BFS 수행
                    if (!bfsCheck(graph, color, i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    // BFS를 통해 이분 그래프 여부를 판별하는 함수
    private static boolean bfsCheck(List<List<Integer>> graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // 첫 번째 노드는 빨강(0)으로 시작

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) { // 방문하지 않은 노드라면
                    color[neighbor] = 1 - color[node]; // 다른 색으로 색칠
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { // 같은 색이면 이분 그래프 아님
                    return false;
                }
            }
        }

        return true;
    }
}
