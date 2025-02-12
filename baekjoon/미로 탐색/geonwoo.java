import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_미로탐색 {
	static int N, M, ans;
	static char [][] map;
	static boolean [][] v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		bfs(0, 0);
		
		System.out.println(ans);
		
	}

	private static void bfs(int sr, int sc) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {sr, sc});
		v[sr][sc] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				int curR = cur[0];
				int curC = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nr = curR+dr[d];
					int nc = curC+dc[d];
					
					if(!check(nr, nc) || v[nr][nc]) continue;
					
					if(nr == N-1 && nc == M-1) {
						ans = cnt+1;
						return;
					}
					
					if(map[nr][nc] == '1') {
						v[nr][nc] = true;
						q.add(new int[] {nr, nc});
					}
					
				}
				
			}
			
			cnt++;
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
