import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        int x = 0;
        int y = 0;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static char[][] arr;
    static List<Integer> counts = new ArrayList<>();
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] array = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String row = br.readLine();
            char[] elements = row.toCharArray();
            array[i] = elements;
        }

        arr = array;

        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(visited[y][x]) continue;
                if(arr[y][x] == '0') continue;
                Point next = new Point(x, y);
                int count = bfs(next);
                counts.add(count);
            }
        }

        Collections.sort(counts);
        System.out.println(counts.size());
        counts.stream().forEach(o-> System.out.println(o));
    }

    private static int bfs(Point point){
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        setVisited(point);

        while(!queue.isEmpty()){
            count++;
            Point current = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if(nx >= 0 && ny >= 0 && ny < n && nx < n && arr[ny][nx] != '0'){
                    if(visited[ny][nx])continue;
                    Point child = new Point(nx, ny);
                    setVisited(child);
                    queue.offer(child);
                }
            }
        }
        return count;
    }

    private static void setVisited(Point point){
        visited[point.y][point.x] = true;
    }
}