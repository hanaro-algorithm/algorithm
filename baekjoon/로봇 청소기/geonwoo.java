import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14503_로봇청소기 {
	
	static int N, M;
	static int [] dr = {-1, 0, 1, 0}; // 위오아왼
	static int [] dc = {0, 1, 0, -1}; // 위오아왼
	static int [][] map;
	// 청소하는 칸의 개수
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		// 로봇 청소기의 시작 정보
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(sr, sc, sd);
		
		System.out.println(cnt);
		
		
	}

	private static void clean(int r, int c, int d) {
		// 청소하지 않은 구역이라면 청소를 하고, 청소했음을 표시(2)
		if (map[r][c] == 0)
		{
			map[r][c] = 2;
			cnt++;
		}
		
		// 네 방향 모두 청소가 되어있거나 벽일 경우 tmp = false 유지
		boolean tmp = false;
		// 원래 보던 방향을 저장할 변수
		int original = d;
		
		for (int i = 0; i < 4; i++) {
			// 바라보던 방향의 왼쪽, 한 칸 앞 좌표 설정
			int nd = (d+3)%4;
			int nr = r+dr[nd];
			int nc = c+dc[nd];
			
			// 맵을 벗어날 경우
			if(!check(nr, nc)) {
				d = (d+3)%4;
				continue;
			}
			
			// 청소할 수 있는 구역이라면 청소하고, tmp를 true로 바꿔준다.
			if(map[nr][nc] == 0) {
				clean(nr, nc, nd);
				tmp = true;
				break;
				}
			d = (d+3)%4;
			}
		
		// 네 방향 모두 청소가 불가능한 경우
		if(!tmp) {
			// 바라보던 방향 뒤로 한칸, 보는 방향은 유지
			int nd = (original+2)%4;
			int nr = r+dr[nd];
			int nc = c+dc[nd];
		
			if(!check(nr, nc)) return;
			
			// 뒷쪽도 벽이라면 작동을 멈춘다. 아니라면 다시 청소 시작
			if(map[nr][nc] != 1) {
				clean(nr, nc, original);
				}
			}
		}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
