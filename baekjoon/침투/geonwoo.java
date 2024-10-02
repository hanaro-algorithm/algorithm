import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_13565_침투 {
	static int N, M;
	static boolean [][] map, v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if(c == '1') map[i][j] = true;
			}
		}
		
		// bfs를 사용하여 맨 윗줄에서 맨 아랫줄에 도달할 수 있는지 확인한다.
		for (int i = 0; i < M; i++) {
			if(!map[0][i] && !v[0][i]) {
				bfs(0, i);
			}
		}
		
		System.out.println("NO");
		
	}

	private static void bfs(int sr, int sc) {
		v[sr][sc] = true;
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				
				// 다음 좌표가 범위를 벗어나거나, 이미 확인했거나, 전류가 통하지 않는다면 continue 
				if(!check(nr, nc) || v[nr][nc] || map[nr][nc]) continue;
				
				// 맨 아래에 도달할 경우 YES를 출력하고 바로 종료한다.
				if(nr == N-1) {
					System.out.println("YES");
					System.exit(0);
				}
				
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
				
			}
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
