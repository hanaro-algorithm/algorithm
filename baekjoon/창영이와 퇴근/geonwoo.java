import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_22116_창영이와퇴근 {
	static class Area implements Comparable<Area> {
		int r;
		int c;
		// 현재까지의 경로 중 최대 경사를 담을 변수
		int max;
		
		public Area(int r, int c, int max) {
			this.r = r;
			this.c = c;
			this.max = max;
		}

		@Override
		public int compareTo(Area o) {
			// max가 작은 순으로 정렬한다.
			return Integer.compare(this.max, o.max);
		}
	}
	
	static final int INF = 1000000000;
	static int N, ans;
	static int [][] map, v;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// N이 1일 경우 0을 출력하고 종료
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 보통 visited 배열을 boolean으로 만들지만,
		// 이 문제에서는 최대 경사가 다를 수 있기 때문에 같은 지점을 여러번 방문할 수 있어야 하므로
		// int로 생성 후 INF 값으로 초기화해준다.
		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], INF);
		}
		
		bfs();
		
		System.out.println(ans);
		
	}

	private static void bfs() {
		// 최대 경사가 낮은 순서대로 사용하여 연산 횟수를 줄이기 위해 pq 사용
		PriorityQueue<Area> pq = new PriorityQueue<>();
		pq.add(new Area(0, 0, 0));
		v[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Area cur = pq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				// 맵을 벗어난 경우 continue
				if(!check(nr, nc)) continue;
				
				// 지금까지 경로 중 최대 경사와 nr, nc를 방문했을 때 경사 중 더 큰 값을 diff에 저장한다.
				int diff = Math.max(cur.max, Math.abs(map[cur.r][cur.c] - map[nr][nc]));
				
				// 끝지점에 도달한 경우 ans를 갱신하고 continue
				if(nr == N-1 && nc == N-1) {
					ans = Math.min(ans, diff);
					continue;
				}
				
				// v[nr][nc]에 이미 diff보다 낮은 경사로 방문한 적이 있다면 continue
				if(v[nr][nc] <= diff) continue;
				
				// 그 외의 경우에는 v[nr][nc]를 갱신하고, pq에 넣어준다.
				v[nr][nc] = diff;				
				pq.add(new Area(nr, nc, diff));
			}
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
