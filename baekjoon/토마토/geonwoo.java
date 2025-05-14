import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7576_토마토 {
	static int N, M;
	static int [][] map;
	static Queue<int []> q;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M 순서 거꾸로 받기
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 토마토 농장의 상태를 저장할 2차원 배열
		map = new int[N][M];
		// bfs를 사용하기 위한 q
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 초기 상태에서 익은 토마토를 q에 넣어준다.
				if(map[i][j] == 1) q.add(new int[] {i, j});
			}
		}
		
		bfs();
		
		int ans = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 만약 농장에 익지 않은 토마토가 1개라도 존재하면 -1을 출력하고 종료한다.
				if(map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				
				// 그 외의 경우에는 ans와 비교해서 갱신한다.
				ans = Math.max(ans, map[i][j]);
				
			}
		}
		
		// 익은 토마토가 1부터 시작했으므로 1을 빼준다.
		System.out.println(ans-1);
		
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				// 맵 범위를 벗어나거나, 벽이거나, 이미 익은 토마토라면 넘어간다.
				if(!check(nr, nc) || map[nr][nc] != 0) continue;
				
				// 그 외의 경우라면 현재 익은 상태에서 + 1 해주고 q에 넣어준다.
				map[nr][nc] = map[r][c] + 1;
				q.add(new int[] {nr, nc});
			}
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
