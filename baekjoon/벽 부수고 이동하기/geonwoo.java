import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2206_벽부수고이동하기 {
	static int N, M, ans = -1;
	static char [][] map;
	static boolean [][][] v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs();
		
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {0, 0, 0});
		v[0][0][0] = true;
		v[0][0][1] = true;
		int t = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int times = cur[2];
				
				if(r == N-1 && c == M-1) {
					ans = t+1;
					return;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(!check(nr, nc)) continue;
					
					if(map[nr][nc] == '0' && !v[nr][nc][times]) {
						v[nr][nc][times] = true;
						q.add(new int[] {nr, nc, times});
					} else if(map[nr][nc] == '1' && times == 0) {
						v[nr][nc][1] = true;
						q.add(new int[] {nr, nc, 1});
					}
				}
				
			}
			
			t++;
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
