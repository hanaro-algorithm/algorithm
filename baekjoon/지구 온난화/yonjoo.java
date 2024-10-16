import java.io.*;
import java.util.*;

public class Main {

    static char[][] wm;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    private boolean isLand(int x, int y){

        int cnt = 0;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(ny < wm.length && nx < wm[0].length && ny >= 0 && nx >= 0){
                if(wm[ny][nx] == '.') cnt++;
            }
            else{
                cnt++;
            }
        }

        return cnt >= 3 ? false : true;
    }
    private void solution(char[][] worldmap){
        char[][] answer = {};
        answer = new char[worldmap.length][worldmap[0].length];

        wm = worldmap;

        int maxX = 0;
        int minX = worldmap[0].length;
        int maxY = 0;
        int minY = worldmap.length;

        for(int i = 0; i < worldmap.length; i++){
            for(int j = 0; j < worldmap[0].length; j++){
                if(wm[i][j] == '.') {
                    answer[i][j] = '.';
                    continue;
                }
                if(isLand(j, i)){
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    answer[i][j] = 'X';
                }
                else{
                    answer[i][j] = '.';
                }
            }
        }

        for(int i = minY; i <= maxY; i++){
            for(int j = minX; j <= maxX; j++){
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char [][] worldmap = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                worldmap[i][j] = str.charAt(j);
            }
        }

        T.solution(worldmap);

    }


}
