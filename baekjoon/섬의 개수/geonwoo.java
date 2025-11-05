import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_4963_섬의개수 {
	
	static int W, H;
	static int [][] map;
	static int [] dr = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int [] dc = { 0, 1, 1, 1, 0,-1,-1,-1};
	
	static class X {
		int r;
	    int c;
	    
		public X(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		if(W == 0 && H == 0) break;
		
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 1) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		
		sb.append(cnt).append('\n');
		
		}
		
		System.out.println(sb.toString());
	}
	
	private static void bfs(int sr, int sc) {
		Queue<X> q = new ArrayDeque<>();
		map[sr][sc] = 0;
		q.offer(new X(sr, sc));

		while(!q.isEmpty()) {
			X x = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nr = x.r+dr[d];
				int nc = x.c+dc[d];
				
				if(!check(nr, nc) || map[nr][nc] == 0) continue;
				
				map[nr][nc] = 0;
				q.add(new X(nr, nc));
			}
			
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

}