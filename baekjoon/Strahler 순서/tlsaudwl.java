import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int maxOrder = 0;
        int count = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= M; i++) graph.add(new ArrayList<>());

            int[] indegree = new int[M + 1];
            Node[] nodes = new Node[M + 1];
            for (int i = 1; i <= M; i++) nodes[i] = new Node();

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                indegree[to]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= M; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    nodes[i].maxOrder = 1;
                    nodes[i].count = 1;
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                int curOrder = nodes[now].maxOrder;

                for (int next : graph.get(now)) {
                    if (nodes[next].maxOrder < curOrder) {
                        nodes[next].maxOrder = curOrder;
                        nodes[next].count = 1;
                    } else if (nodes[next].maxOrder == curOrder) {
                        nodes[next].count++;
                    }

                    indegree[next]--;
                    if (indegree[next] == 0) {
                        if (nodes[next].count >= 2) {
                            nodes[next].maxOrder++;
                        }
                        q.offer(next);
                    }
                }
            }

            System.out.println(K + " " + nodes[M].maxOrder);
        }
    }
}
