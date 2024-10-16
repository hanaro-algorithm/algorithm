import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] calendar = new boolean[1000][366];
    static int[] Height = new int[366];
    static PriorityQueue<int[]> input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int S, E, Level, ans = 0;
        int[] q;
        input = new PriorityQueue<>((o1, o2) -> {
            int comp = Integer.compare(o1[0], o2[0]);
            if (comp == 0) {
                return -Integer.compare(o1[1], o2[1]);
            } else
                return comp;
        });

        N = Integer.parseInt(br.readLine());

        //정렬
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            input.add(new int[]{S, E});
        }

        //일정 표시하기
        for (int i = 0; i < N; i++) {
            q = input.poll();
            S = q[0];
            E = q[1];

            Level = 0;

            for (int j = S; j <= E; j++) {
                if (calendar[Level][j] == true) {
                    Level++;
                    j = S - 1;
                }
            }

            for (int j = S; j <= E; j++) {
                calendar[Level][j] = true;
            }
        }

        //높이 계산하기
        for (int i = 1; i <= 365; i++) {
            int max = 0;
            for (int j = 0; j < 1000; j++) {
                if (calendar[j][i])
                    max = Math.max(j + 1, max);
            }
            Height[i] = max;
        }

        int w = 0, h = 0;
        //코팅하기
        for (int i = 1; i <= 365; i++) {
            if (Height[i] == 0) {
                ans += w * h;
                w = 0;
                h = 0;
            } else {
                w++;
                h = Math.max(Height[i], h);
            }
        }

        if (Height[365] != 0)
            ans += w * h;

        System.out.println(ans);
        br.close();

    }
}