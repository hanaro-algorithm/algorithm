import java.io.*;
import java.util.*;

public class Main {


    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[][] room;
    static int N, M; //세로 가로
    static int count = 1;

    static void DFS(int x, int y, int direction){

        room[y][x] = 2;
        
        int newDir = direction;
        for(int d = 0; d < 4; d++){
            newDir = (newDir + 3)%4;
            int nx = x + dx[newDir];
            int ny = y + dy[newDir];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N && room[ny][nx] != 1){
                if(room[ny][nx] == 0){

                    count += 1;

                    DFS(nx, ny, newDir);
                    return;
                }
            }
        }


        int opposite = (direction + 2)%4;
        int bx = x + dx[opposite];
        int by = y + dy[opposite];

        if(room[by][bx] == 1) return;
        if(bx >= 0 && by >= 0 && bx < M && by < N && room[by][bx] != 1) DFS(bx, by, direction);
    }



    private void solution(int x, int y, int d){

        if(room[y][x] == 1) {
            System.out.println(0);
            return;
        }

        DFS(x, y, d);
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        room = new int[N][M];



        st = new StringTokenizer(br.readLine());
        int robotY, robotX, robotDir;
        robotY = Integer.parseInt(st.nextToken());
        robotX = Integer.parseInt(st.nextToken());
        robotDir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        T.solution(robotX, robotY, robotDir);

    }
}