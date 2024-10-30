import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int maxHeight;

    class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private boolean isNext(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= N || visited[y][x]) return false;
        return true;
    }

    private int BFS(int height, int x, int y){
        if(visited[y][x]) return 0;
        visited[y][x] = true;

        if(map[y][x] < height) return 0;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()){
            Point curr = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(isNext(nx, ny) && map[ny][nx] >= height){
                    q.offer(new Point(nx, ny));
                    visited[ny][nx] = true;
                }
            }

        }

        return 1;
    }
    private int solution(){
        int answer = 0;
        int cnt;
        for(int i = 1; i <= maxHeight; i++){
            cnt = 0;
            for(int k = 0; k < N; k++){
                Arrays.fill(visited[k], false);
            }

            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    cnt += BFS(i, x, y);
                }
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        maxHeight = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        T.solution();

        System.out.println(T.solution());
    }


}