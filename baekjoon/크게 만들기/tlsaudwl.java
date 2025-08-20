import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char now = num.charAt(i);

            while (!stack.isEmpty() && K > 0 && stack.peekLast() < now) {
                stack.pollLast();
                K--;
            }

            stack.addLast(now);
        }

        while (K > 0) {
            stack.pollLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
