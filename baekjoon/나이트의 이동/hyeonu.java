import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visit;
    static int l, sx, sy, ex, ey;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            visit = new boolean[l][l];
            System.out.println(bfs());
        }
    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0]; // 현재 위치
            int cy = cur[1];
            int cnt = cur[2]; // 이동 수

            // 목표 위치 도달
            if(cx == ex && cy == ey){
                return cnt;
            }

            // 8방향 이동
            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 유효 범위, 미방문
                if(nx >= 0 && ny >= 0 && nx < l && ny < l && !visit[nx][ny]){
                    q.add(new int[]{nx, ny, cnt + 1});
                    visit[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
