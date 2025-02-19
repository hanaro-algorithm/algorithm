import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(bfs(A, K));
    }

    public static int bfs(int A, int K) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[K + 1];

        queue.add(new int[]{A, 0});
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int count = current[1];

            if (num == K) return count;

            if (num + 1 <= K && !visited[num + 1]) {
                queue.add(new int[]{num + 1, count + 1});
                visited[num + 1] = true;
            }

            if (num * 2 <= K && !visited[num * 2]) {
                queue.add(new int[]{num * 2, count + 1});
                visited[num * 2] = true;
            }
        }
        return -1;
    }
}
