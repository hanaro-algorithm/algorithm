import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S4_1205_등수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(1);
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        int rank = 1;

        for (int score : list) {
            int cnt = map.get(score);

            if(score < M) break;
            else if(score == M) {
                if(rank+cnt > P) rank = -1;

                break;
            }

            rank += cnt;

            if(rank > P) {
                rank = -1;
                break;
            }
        }

        System.out.println(rank);

    }

}

