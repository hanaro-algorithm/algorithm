import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());   // 게임 구역의 크기
        map = new int[n][n];    // 게임 맵
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());   // 게임 맵 입력받기
            }
        }
        dfs(0, 0);
        System.out.println("Hing");
    }
    private static void dfs(int i, int j){
        if(map[i][j] == -1){
            System.out.println("HaruHaru");
            System.exit(0);
        }
        for (int k = 0; k < 2; k++){
            int x = i + dx[k] * map[i][j];
            int y = j + dy[k] * map[i][j];
            if(x >= n || y >= n || visited[x][y]){
                continue;
            }
            visited[x][y]= true;
            dfs(x, y);
        }
    }
}