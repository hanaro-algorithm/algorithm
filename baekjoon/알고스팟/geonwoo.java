import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class BOJ_G4_1261_알고스팟 {
    static int N, M, ans;
    static int [][] map;
    static boolean [][] v;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    
    static class P implements Comparable<P> {
        int r;
        int c;
        int cnt;
     
        P(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
     
        @Override
        public int compareTo(P o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
 
        map = new int[N][M];
        v = new boolean[N][M];
 
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
 
        bfs(0, 0);
        
        System.out.println(ans);
    }
 
    public static void bfs(int r, int c) {
        PriorityQueue<P> pq = new PriorityQueue<>();
        pq.add(new P(r, c, 0));
        v[r][c] = true;
 
        while (!pq.isEmpty()) {
            P cur = pq.poll();
 
            if (cur.r == N-1 && cur.c == M-1) {
                ans = cur.cnt;
                return;
            }
 
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
 
                if(!check(nr, nc) || v[nr][nc]) continue;
 
                if (map[nr][nc] == 0) {
                    v[nr][nc] = true;
                    pq.add(new P(nr, nc, cur.cnt));
                } else {
                	v[nr][nc] = true;
                    pq.add(new P(nr, nc, cur.cnt+1));
                }
                
            }
        }
        
    }

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
 
}