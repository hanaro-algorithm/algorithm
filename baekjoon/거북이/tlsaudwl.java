import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            String commands = sc.nextLine();
            System.out.println(move(commands));
        }
    }

    static int move(String commands) {
        int x = 0, y = 0;
        int dir = 0;

        int maxX = 0, maxY = 0, minX = 0, minY = 0;

        for (char cmd : commands.toCharArray()) {
            if (cmd == 'F') {
                x += dx[dir];
                y += dy[dir];
            } else if (cmd == 'B') {
                x -= dx[dir];
                y -= dy[dir];
            } else if (cmd == 'L') {
                dir = (dir + 3) % 4;
            } else if (cmd == 'R') {
                dir = (dir + 1) % 4;
            }

            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
        }

        int width = maxX - minX;
        int height = maxY - minY;

        return width * height;
    }
}
