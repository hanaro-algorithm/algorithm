import java.util.*;
import java.io.*;

public class Main {

    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, K;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

    static int[][] map;

    private boolean isNext(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M || map[y][x] != 0) return false;
        return true;
    }

    private int BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        int sum = 1;
        while(!q.isEmpty()){
            Point curr =q.poll();
            for(int d = 0; d < 4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(isNext(nx, ny)){
                    map[ny][nx] = -1;
                    sum += 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        return sum;
    }

    private void solution(){
        int sum = 0;
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0) continue;
                map[i][j] = -1;
                cnt++;
                ans.add(BFS(j, i));
            }
        }

        ans.sort(Integer::compare);

        System.out.println(cnt);
        for(int i : ans) System.out.print(i + " ");
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            for(int y = ay; y < by; y++){
                for(int x = ax; x < bx; x++){
                    map[y][x] = 1;
                }
            }
        }

        T.solution();


    }
}