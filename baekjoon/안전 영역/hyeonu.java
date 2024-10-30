import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] flood, visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int max = 0, cnt, ans = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        flood = new boolean[N][N];
        for(int r = 0; r <= max; r++){
            isF(r);
            cnt = 0;
            visit = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!flood[i][j] && !visit[i][j])
                        cnt += bfs(new int[]{i,j});
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    static void isF(int rain){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] <= rain)
                    flood[i][j] = true;
            }
        }
    }
    static int bfs(int[] s){
        Queue<int[]> q = new LinkedList<>();
        q.offer(s);
        visit[s[0]][s[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr>=0&&nc>=0&&nr<N&&nc<N&&!flood[nr][nc]&&!visit[nr][nc]){
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return 1;
    }
}