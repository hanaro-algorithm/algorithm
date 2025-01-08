import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_26169_세번이내에사과를먹자 {
	static int [][] map;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		
		dfs(sr, sc, 0, 0);
		
		System.out.println(0);
	}

	private static void dfs(int r, int c, int depth, int apple) {
		if(map[r][c] == 1) {
			if(++apple == 2) {
				System.out.println(1);
				System.exit(0);
			}
		}
		
		if(depth == 3) return;
		
		int origin = map[r][c];
		map[r][c] = -1;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc) || map[nr][nc] == -1) continue;
			
			dfs(nr, nc, depth+1, apple);
		}
		
		map[r][c] = origin;
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<5 && c>=0 && c<5;
	}

}
