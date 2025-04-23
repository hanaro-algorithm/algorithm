import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_1937_욕심쟁이판다 {
	static int N;
	static int [][] map, memo;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(memo[i][j] == -1) {					
					memo[i][j] = dfs(i, j);
				}
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, memo[i][j]);
			}
		}
		
		System.out.println(max+1);
		
	}

	private static int dfs(int r, int c) {
		if(memo[r][c] != -1) return memo[r][c];
		
		int max = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc) || map[r][c] >= map[nr][nc]) continue;
			
			int dist = dfs(nr, nc)+1;
			
			max = Math.max(max, dist);
		}
		
		memo[r][c] = max;

		return max;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
