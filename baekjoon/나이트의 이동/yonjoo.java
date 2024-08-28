import java.io.*;
import java.util.*;


public class Main {

    public static int N;
    public static int[][] chessboard;
    public static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};


    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point start = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = start.x + dx[i];
                int newY = start.y + dy[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < N) {
                        if (!visited[newX][newY]) {
                            queue.add(new Point(newX, newY));
                            chessboard[newX][newY] = chessboard[start.x][start.y] + 1;
                            visited[newX][newY] = true;
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TR = Integer.parseInt(br.readLine());

        for (int t = 0; t < TR; t++) {

            N = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] split = line1.split(" ");
            int currentX = Integer.parseInt(split[0]);
            int currentY = Integer.parseInt(split[1]);

            String line2 = br.readLine();
            String[] split1 = line2.split(" ");
            int destinationX = Integer.parseInt(split1[0]);
            int destinationY = Integer.parseInt(split1[1]);

            visited = new boolean[N][N];
            chessboard = new int[N][N];

            T.bfs(currentX, currentY);

            bw.write(chessboard[destinationX][destinationY] + "\n");
        }

        bw.flush();
    }
}
