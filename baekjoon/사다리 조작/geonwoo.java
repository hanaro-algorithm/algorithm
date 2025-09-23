import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_15684_사다리조작 {
	static int N, M, H;
	static int [][] map;
	static boolean flag;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N+1];
		ans = -1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// map의 1은 오른쪽으로 이동 가능 가로선 
			map[a][b] = 1;
			// map의 2는 왼쪽으로 이동 가능 가로선
			map[a][b+1] = 2;
		}
		
		for (int i = 0; i <= 3; i++) {
			if(!flag) {
				dfs(0, 0, i);
			}
		}
		
		System.out.println(ans);
	}

	// depth:높이, ladder:사다리개수, max:사다리 제한 개수(0~3개)
	private static void dfs(int depth, int ladder, int cnt) {
		if (flag) {
			return;
		}
		
		if(ladder == cnt) {
			if(check()) {
				ans = cnt;
				flag = true;
			}
			return;
		}
		
		for (int i = depth; i <= H; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) { // 가로선이 없는 경우
					map[i][j] = 1; // 가로선 놓아주기 1
					map[i][j+1] = 2; // 가로선 놓아주기 2
					dfs(depth, ladder+1, cnt);
					map[i][j] = map[i][j+1] = 0; // 놓았던 가로선 회수하기
				}
			}
		}
		
	}

	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = 1; // 현재 사다리에서의 높이
			int y = i; // 현재 사다리 번호
			for (int j = 0; j < H; j++) {
				if(map[x][y] == 1) {
					y++;
				} else if(map[x][y] == 2) {
					y--;
				}
				x++;
			}
			
			if(y != i) {
				return false;
			}
		}
		return true;
	}

}
