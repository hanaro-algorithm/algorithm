import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n, m, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //배열은 통로의 길이보다 1씩 크게
        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //음쓰 위치
            arr[x][y] = 1;
        }

        int max = 0; //젤 큰 음쓰

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //음쓰ㅇ 아직 방문ㄴ
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = 1; //크기 초기화
                    dfs(i, j);
                    max = Math.max(max, cnt); //젤 큰 음쓰 갱신
                }
            }
        }

        System.out.println(max);
    }

    private static void dfs(int a, int b) {
        //사방 탐색
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            //좌표 안 벗어나고 음쓰 ㅇ 방문 ㄴ
            if (x > 0 && y > 0 && x <= n && y <= m &&
                    arr[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                cnt++;
                dfs(x, y);
            }
        }
    }
}
