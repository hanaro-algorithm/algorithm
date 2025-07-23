import java.util.*;

public class Main {
    static class Emoticon {
        int screen, clipboard, time;

        Emoticon(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        boolean[][] visited = new boolean[2001][2001];
        Queue<Emoticon> q = new LinkedList<>();

        q.add(new Emoticon(1, 0, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            Emoticon now = q.poll();

            if (now.screen == S) {
                System.out.println(now.time);
                return;
            }

            if (!visited[now.screen][now.screen]) {
                visited[now.screen][now.screen] = true;
                q.add(new Emoticon(now.screen, now.screen, now.time + 1));
            }

            if (now.clipboard > 0 && now.screen + now.clipboard < 2000) {
                if (!visited[now.screen + now.clipboard][now.clipboard]) {
                    visited[now.screen + now.clipboard][now.clipboard] = true;
                    q.add(new Emoticon(now.screen + now.clipboard, now.clipboard, now.time + 1));
                }
            }

            if (now.screen > 0 && !visited[now.screen - 1][now.clipboard]) {
                visited[now.screen - 1][now.clipboard] = true;
                q.add(new Emoticon(now.screen - 1, now.clipboard, now.time + 1));
            }
        }
    }
}
