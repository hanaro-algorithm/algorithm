import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_21736_헌내기는친구가필요해 {
    static int N, M, sr, sc;
    static char [][] map;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'I'){
                    sr = i;
                    sc = j;
                }
            }
        }

        int ans = bfs(sr, sc);

        System.out.println(ans == 0 ? "TT" : ans);

    }

    private static int bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sr, sc});
        boolean [][] v = new boolean[N][M];
        v[sr][sc] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = curR+dr[d];
                int nc = curC+dc[d];

                if(!check(nr, nc) || v[nr][nc] || map[nr][nc] == 'X') continue;

                if(map[nr][nc] == 'P') cnt++;

                v[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }

        }

        return cnt;
    }

    private static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

}