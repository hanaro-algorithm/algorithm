import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] mov = {{-1, 0},{1, 0},{0, -1},{0, 1}};   // 상, 하, 좌, 우
    static boolean check = false;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            for(int j = 0; i < N; j++){
                map[i][j] = str.charAt(j) - '0';    //
            }
        }
        for(int i = 0; i < M; i++){
            if(map[0][i] == 0){
                dfs(0, i);
            }
        }
        System.out.println(check ? "YES" : "NO");
    }

    private static void dfs(int row, int col){
        visited[row][col] = true;       // 방문여부 true
        if(row == N-1 && map[row][col] == 0){
            check = true;
            return;
        }
        for(int i = 0; i < mov.length; i++){
            int a = row + mov[i][0];
            int b = col + mov[i][1];

            if(a >= 0 && b >= 0 && a < N && b < M && !visited[a][b] && map[a][b] == 0){
                dfs(a, b);
            }
        }
    }
}