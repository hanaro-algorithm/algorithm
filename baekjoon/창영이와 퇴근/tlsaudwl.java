import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist; // 각 위치까지의 최소한의 최대 높이 차이 저장
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE; // 초기값 설정
            }
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0)); // 시작점 (0,0)에서 높이 차이 0부터 시작
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x, y = current.y, maxDiff = current.maxDiff;

            if (x == N - 1 && y == N - 1) return maxDiff; // 목표 지점 도착하면 종료

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int heightDiff = Math.abs(map[x][y] - map[nx][ny]);
                    int newMaxDiff = Math.max(maxDiff, heightDiff);

                    if (newMaxDiff < dist[nx][ny]) { // 더 작은 최대 높이 차이로 갱신 가능하면 업데이트
                        dist[nx][ny] = newMaxDiff;
                        pq.add(new Node(nx, ny, newMaxDiff));
                    }
                }
            }
        }
        return -1;
    }

    // 우선순위 큐에서 사용할 클래스 (최소 힙)
    static class Node implements Comparable<Node> {
        int x, y, maxDiff;

        public Node(int x, int y, int maxDiff) {
            this.x = x;
            this.y = y;
            this.maxDiff = maxDiff;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.maxDiff, other.maxDiff); // 최소값 기준 정렬
        }
    }
}
