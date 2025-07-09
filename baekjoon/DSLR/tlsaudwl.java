import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(bfs(A, B));
        }
    }

    public static String bfs(int start, int target) {
        boolean[] visited = new boolean[MAX];
        Queue<int[]> queue = new LinkedList<>();
        String[] commands = new String[MAX];

        queue.add(new int[]{start});
        visited[start] = true;
        commands[start] = "";

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];

            if (value == target) return commands[value];

            // D
            int d = (value * 2) % MAX;
            if (!visited[d]) {
                visited[d] = true;
                commands[d] = commands[value] + "D";
                queue.add(new int[]{d});
            }

            // S
            int s = (value == 0) ? 9999 : value - 1;
            if (!visited[s]) {
                visited[s] = true;
                commands[s] = commands[value] + "S";
                queue.add(new int[]{s});
            }

            // L
            int l = (value % 1000) * 10 + (value / 1000);
            if (!visited[l]) {
                visited[l] = true;
                commands[l] = commands[value] + "L";
                queue.add(new int[]{l});
            }

            // R
            int r = (value % 10) * 1000 + (value / 10);
            if (!visited[r]) {
                visited[r] = true;
                commands[r] = commands[value] + "R";
                queue.add(new int[]{r});
            }
        }

        return "";
    }
}
