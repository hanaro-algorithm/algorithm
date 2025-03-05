import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_2146_다리만들기 {
	static int N, min;
	static int [][] map;
	static boolean [][] v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		// 놓을 수 있는 가장 짧은 다리의 길이
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 떨어져있는 대륙을 나눠서 번호를 붙여준다.
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					divide(i, j, idx++);
				}
			}
		}
		
		// 땅 중에서 가장자리에 있는 땅들에서 bfs를 사용하여 다른 대륙의 땅을 찾는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 바다가 아니고, 가장자리라면 bfs 사용
				if(map[i][j] != 0 && isEdge(i, j)) {
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);
		
	}

	// 한 땅에서 가장 가까운 다른 대륙의 땅을 찾는 bfs
	private static void bfs(int sr, int sc, int idx) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {sr, sc});
		v = new boolean[N][N];
		v[sr][sc] = true;
		// 다른 대륙까지의 거리
		int dist = 0;
		
		while(!q.isEmpty()) {
			// 사이즈 만큼만 for문을 돌려 거리 계산을 편하게 할 수 있다.
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				int curR = cur[0];
				int curC = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nr = curR+dr[d];
					int nc = curC+dc[d];
					
					if(!check(nr, nc) || v[nr][nc]) continue;
					
					// 바다인 경우에는 방문 처리 후 q에 다시 넣어준다.
					if(map[nr][nc] == 0) {
						v[nr][nc] = true;
						q.add(new int[] {nr, nc});
					// 다른 대륙을 발견한 경우 최단 거리를 갱신하고 bfs 함수를 종료한다.
					} else if(map[nr][nc] != idx) {
						min = Math.min(min, dist);
						return;
					}
					
				}
			}
			
			// 사이즈만큼 확인했다면 dist를 +1 해준다.
			dist++;
		}
		
	}

	// 상하좌우에 바다가 1개라도 있으면 가장자리이다.
	private static boolean isEdge(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(check(nr, nc) && map[nr][nc] == 0) return true;
		}
		
		return false;
	}

	// 각 대륙을 나눠서 번호를 붙여주는 bfs
	private static void divide(int sr, int sc, int idx) {
		Queue<int []> q = new ArrayDeque<>();
		map[sr][sc] = idx;
		v[sr][sc] = true;
		q.add(new int [] {sr, sc});
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				
				if(!check(nr, nc) || v[nr][nc] || map[nr][nc] == 0) continue;
				
				map[nr][nc] = idx;
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
	}

	// 맵 밖을 벗어나는 경우 체크용 함수
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
