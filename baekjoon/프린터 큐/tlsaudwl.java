import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.offer(new int[]{i, priority});
                priorityQueue.offer(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[1] == priorityQueue.peek()) {
                    count++;
                    priorityQueue.poll();

                    if (current[0] == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

    }
}
