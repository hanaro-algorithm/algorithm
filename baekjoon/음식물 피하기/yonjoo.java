import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private class Point {
        int x;
        int y;

        Point(int x, int y){this.x = x; this.y = y;}
    }

    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};


    static int height;
    static int width;

    static Queue<Point> q = new LinkedList<>();

    private int bfs(int x, int y){

        int cnt = 0;
        int cx, cy;

        q.offer(new Point(x, y));
        while(!q.isEmpty()){

            Point curr = q.poll();
            cx = curr.x;
            cy = curr.y;

            cnt++;


            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx >=0 && nx < width && ny >= 0 && ny < height && !visited[ny][nx] && graph[ny][nx] == 1 ){
                    q.offer(new Point(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }

        return cnt;
    }

    public int solution(){


        int x, y;
        int maxcnt = 0;
        for(x = 0; x < width; x++){
            for(y = 0; y < height; y++){
                if(!visited[y][x] && graph[y][x] == 1){
                    visited[y][x] = true;

                    maxcnt = Math.max(maxcnt, bfs(x, y));
                }
            }
        }

        return maxcnt;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        /*
        입력부
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[height][width];
        graph = new int[height][width];

        for(int i = 0; i < K; i++){
            String[] p = br.readLine().split(" ");
            graph[Integer.parseInt(p[0])-1][Integer.parseInt(p[1])-1] = 1;
        }



        /*
        출력부
         */
        System.out.println(T.solution());

    }
}
