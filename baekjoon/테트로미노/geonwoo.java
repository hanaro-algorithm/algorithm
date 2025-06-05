import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_14500_테트로미노 {
	static int N, M, max;
	static int [][] map;
	static boolean [][] v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i, j, map[i][j], 1);
				v[i][j] = false;
			}
		}

		System.out.println(max);
		
	}

	static void dfs(int r, int c, int sum, int cnt) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];

			if(!check(nr, nc) || v[nr][nc]) continue;

			// 보라색 전용
			if(cnt == 2) {
				v[nr][nc] = true;
				dfs(r, c, sum + map[nr][nc], cnt+1);
				v[nr][nc] = false;
			}

			v[nr][nc] = true;
			dfs(nr, nc, sum + map[nr][nc], cnt+1);
			v[nr][nc] = false;
			
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}