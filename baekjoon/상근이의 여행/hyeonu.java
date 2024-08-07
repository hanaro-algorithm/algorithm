import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드 수
            int M = Integer.parseInt(st.nextToken()); // 간선 수

            // 간선 정보는 읽지만 실제로는 사용하지 않음
            for (int j = 0; j < M; j++) {
                br.readLine();
            }

            // 모든 노드를 연결하기 위한 최소 간선 수는 N - 1
            System.out.println(N - 1);
        }
    }
}
