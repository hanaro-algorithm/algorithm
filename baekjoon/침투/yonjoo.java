import java.io.*;
import java.util.*;

/*
DFS가 더 빠름 왜?
 */
public class Main {

    static int M, N;
    static int[][] array;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};

    class Point{
        int x, y;
        Point(int x, int y){this.x = x; this.y = y;}
    }

    private boolean isNextPoint(Point point){
        int nx = point.x, ny = point.y;
        if(ny >= 0 && ny < M && nx >= 0 && nx < N && !visited[ny][nx] && array[ny][nx] == 0) return true;

        return false;
    }

    
    //DFS 
    private String solution2(int m, int n, int[][] arr){
        M = m; N = n;

        array = arr;
        visited = new boolean[M][N];

        for(int i = 0; i < N; i++){
            if(array[0][i] == 0){
                visited[0][i] = true;
                if(DFS(new Point(i, 0))){
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private boolean DFS(Point curr){

        if(curr.y == M - 1){
            return true;
        }
        else{
            for(int d = 0; d < 4; d++){
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                Point next = new Point(nx, ny);
                if(isNextPoint(next)){
                    visited[ny][nx] = true;
                    if(DFS(next)) return true;
                }
            }
        }
        return false;
    }
    
    //BFS
    private String solution(int m, int n, int[][] arr) {

        M = m; N = n;

        array = arr;
        visited = new boolean[M][N];
        if(BFS()) return "YES";
        return "NO";
    }

    private boolean BFS(){
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(array[0][i] == 0){
                q.offer(new Point(i, 0));
                visited[0][i] = true;
            }
        }

        while(!q.isEmpty()){
            Point curr = q.poll();

            if(curr.y == (M - 1)){
                return true;
            }

            for(int d = 0; d < 4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(nx >= 0 && nx < N && ny >=0 && ny < M && array[ny][nx] == 0 && !visited[ny][nx]){
                    q.offer(new Point(nx, ny));
                    visited[ny][nx] = true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] ar = new int[m][n];

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++){
                ar[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(T.solution2(m, n, ar));
    }
}
