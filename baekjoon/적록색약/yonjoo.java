import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n = 0;
    static char[][] array;
    static char[][] abarray;
    static boolean[][] visited;

    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static class Point{
        int x = 0;
        int y = 0;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static void setVisitied(Point p){
        visited[p.y][p.x] = true;
    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new char[n][n];
        abarray = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String in = br.readLine();
            char[] chars = in.toCharArray();
            char[] abchars = in.replace('G', 'R').toCharArray();

            array[i] = chars;
            abarray[i] = abchars;
        }


        int count = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(visited[y][x]) continue;
                Point point = new Point(x, y);
                bfs(point, array);
                count += 1;
            }
        }


        visited = new boolean[n][n];
        int abcount = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(visited[y][x]) continue;
                Point point = new Point(x, y);
                bfs(point, abarray);
                abcount += 1;
            }
        }

        System.out.print(count + " "+ abcount);


    }

    private static Character bfs(Point point, char[][] array){

        Character character = array[point.y][point.x];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        setVisitied(point);


        while (!queue.isEmpty()){
            Point now = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]){
                    if(array[ny][nx] != character) continue;
                    Point next = new Point(nx, ny);
                    setVisitied(next);
                    queue.offer(next);
                }
            }
        }
        return character;
    }

}