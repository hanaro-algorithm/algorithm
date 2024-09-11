import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_14620_꽃길 {
	static int N, min;
	static int [][] map;
	static boolean [][] v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		// 최소 비용을 저장할 변수
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		// 칸에 꽃이 심어져 있는지 확인할 2차원 배열
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs + 백트래킹을 이용하여 모든 경우를 확인해본다.
		dfs(0, 0);
		
		System.out.println(min);
		
	}

	private static void dfs(int cnt, int sum) {
		// sum이 min보다 커진 경우 바로 리턴한다.
		if(sum >= min) return;
		
		// 꽃 3개를 심었는데 sum이 min보다 작다면 min을 갱신한다.
		if(cnt == 3) {
			min = sum;
			return;
		}
		
		// i~N-2까지 확인하면 화단 밖으로 벗어날 일이 없다.
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				// 이미 꽃이 심어져 있거나 상하좌우에 꽃이 겹치는 경우는 넘어간다.
				if(v[i][j] || !check(i, j)) continue;
				
				// 해당 칸에 꽃을 심었을 때의 비용을 계산한다.
				int cost = cal(i, j);
				// 꽃을 심는다.
				reverse(i, j);
				// 다음 꽃을 심을 장소를 찾는다.
				dfs(cnt+1, sum+cost);
				// 꽃을 없앤다.
				reverse(i, j);
				
			}
		}
		
	}

	// 꽃이 없으면 심고, 있으면 없애는 함수
	private static void reverse(int r, int c) {
		v[r][c] = v[r][c] ? false : true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			v[nr][nc] = v[nr][nc] ? false : true;
		}
		
	}

	// r, c에 꽃을 심었을 때의 비용을 계산하는 함수
	private static int cal(int r, int c) {
		int cost = map[r][c];
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			cost += map[nr][nc];
		}
		
		return cost;
	}

	// 상하좌우에 겹치는 꽃이 있는지 확인하는 함수
	private static boolean check(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(v[nr][nc]) return false;
		}
		
		return true;
	}

}
