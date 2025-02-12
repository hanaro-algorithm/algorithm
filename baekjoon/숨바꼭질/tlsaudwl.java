import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        if (N == K) {
            System.out.println(0);
            return;
        }

        System.out.println(findFastestTime(N, K));
    }

    public static int findFastestTime(int start, int target) {
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 이동할 수 있는 3가지 경우
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 목표 위치에 도착하면 바로 출력
                if (next == target) {
                    return visited[current];
                }

                // 방문한 적 없고, 범위 안에 있을 때만 이동
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
        return -1;
    }
}
