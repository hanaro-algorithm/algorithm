import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] train = new boolean[N+1][21];

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (cmd == 1) { // x번에 사람 태우기
                int x = Integer.parseInt(st.nextToken());
                train[i][x] = true;
            } else if (cmd == 2) { // x번에 사람 내리기
                int x = Integer.parseInt(st.nextToken());
                train[i][x] = false;
            } else if (cmd == 3) { // 오른쪽으로 한 칸 이동
                for (int x = 20; x > 1; x--) {
                    train[i][x] = train[i][x - 1];
                }
                train[i][1] = false;
            } else if (cmd == 4) { // 왼쪽으로 한 칸 이동
                for (int x = 1; x < 20; x++) {
                    train[i][x] = train[i][x + 1];
                }
                train[i][20] = false;
            }
        }


        HashSet<String> passTrain = new HashSet<>();

        for (int i = 1; i <= N; i++) { // 기차 번호
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) { // 좌석 번호
                sb.append(train[i][j] ? '1' : '0');
            }
            passTrain.add(sb.toString());
        }

        System.out.println(passTrain.size());
    }
}
