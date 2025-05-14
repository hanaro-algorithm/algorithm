import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1600_말이되고픈원숭이 {
	static int K, W, H, ans;
	static int [][] map;
	static boolean [][][] v;

	static class Monkey {
		int r;
		int c;
		int cnt;
		int k;
		
		Monkey (int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	// 동서남북(원숭이) 좌우상하(말) 
		static int[] dr = {0, 0, 1, -1};
		static int[] dc = {1, -1, 0, 0}; 
		static int[] hr = {-2, -2, 2, 2, 1, -1, 1, -1};
		static int[] hc = {1, -1, 1, -1, 2, 2, -2, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int [H][W];
		v = new boolean [H][W][31];
		ans = -1;
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		
		System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Monkey> q = new ArrayDeque<>();
		v[0][0][0] = true;
		q.add(new Monkey(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int cnt = cur.cnt;
			int curk = cur.k;
			
			if(r == H-1 && c == W-1) {
				ans = cnt;
				return;
			}
			
			// monkey
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc) || map[nr][nc] == 1 || v[nr][nc][curk]) continue;
				
				v[nr][nc][curk] = true;
				q.add(new Monkey(nr, nc, cnt+1, curk));
			}
			
			// horse
			if(curk >= K) continue;
			
			for (int d = 0; d < 8; d++) {
				int nr = r+hr[d];
				int nc = c+hc[d];
				
				if(!check(nr, nc) || map[nr][nc] == 1 || v[nr][nc][curk+1]) continue;
				
				v[nr][nc][curk+1] = true;
				q.add(new Monkey(nr, nc, cnt+1, curk+1));
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

}
