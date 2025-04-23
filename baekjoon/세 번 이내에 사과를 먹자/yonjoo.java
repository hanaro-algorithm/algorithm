import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

    static boolean flag = false;
    static int COUNT_BOUND = 2;
    static int DEPTH_BOUND = 3;

    private boolean isNext(int r, int c){
        if(r < 0 || r >= map.length || c < 0 || c >= map.length || map[r][c] == -1) return false;
        return true;
    }

    private void dfs(int depth, int r, int c, int count){

        if(flag) return;
        if(depth == DEPTH_BOUND|| count >= COUNT_BOUND){
            if (count >= COUNT_BOUND) flag = true;
            return;
        }
        for(int d = 0; d < dx.length; d += 1){
            int nr = r + dx[d];
            int nc = c + dy[d];

            if(!isNext(nr, nc)) continue;
            if(map[nr][nc] == -1) continue;

            int temp = map[nr][nc];
            map[nr][nc] = -1;
            dfs(depth + 1, nr, nc, temp == 1 ? count + 1 : count);
            map[nr][nc] = temp;
        }
    }
    private void solution(int currR, int currC){
        map[currR][currC] = -1;
        dfs(0, currR, currC, 0);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        map = new int[5][5];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int currR = Integer.parseInt(st.nextToken());
        int currC = Integer.parseInt(st.nextToken());

        T.solution(currR, currC);
        sb.append(flag ? 1 : 0);
        System.out.println(sb.toString());

    }
}