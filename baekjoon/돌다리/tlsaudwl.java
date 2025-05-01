import java.util.*;

public class Main {
    static final int MAX = 100_001;

    static class Node {
        int position, count;
        Node(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] visited = new boolean[MAX];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.position == M) {
                System.out.println(current.count);
                return;
            }

            int[] moves = {
                    current.position + 1,
                    current.position - 1,
                    current.position + A,
                    current.position - A,
                    current.position + B,
                    current.position - B,
                    current.position * A,
                    current.position * B
            };

            for (int next : moves) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, current.count + 1));
                }
            }
        }
    }
}
