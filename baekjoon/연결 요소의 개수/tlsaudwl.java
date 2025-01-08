import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프를 표현할 인접 리스트
    static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점
        int m = sc.nextInt(); // 간선

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v); // u -> v
            graph[v].add(u); // v -> u
        }

        // 방문 여부 배열 초기화
        visited = new boolean[n + 1];

        int connectedComponents = 0; // 연결 요소 개수

        // 모든 정점에 대해 DFS 실행
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponents++;
            }
        }

        System.out.println(connectedComponents);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
