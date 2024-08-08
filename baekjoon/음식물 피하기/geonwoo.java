import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1743_음식물피하기 {
	static int N, M, max;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int [][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 0은 통로, 1은 탐색하지 않은 음식물, 2는 이미 탐색한 음식물
		map = new int[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 탐색하지 않은 음식물에 대해 bfs를 이용하여 연결된 음식물을 확인한다.
				if(map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void bfs(int r, int c) {
		// queue 선언
		Queue<int []> q = new ArrayDeque<>();
		// r, c의 음식물은 확인 처리를 한다.
		map[r][c] = 2;
		q.add(new int[] {r, c});
		// r, c의 음식물의 크기를 저장할 변수
		int size = 1;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			// 4가지 방향에 대해 확인해본다.
			for (int d = 0; d < 4; d++) {
				// curR, curC의 다음 좌표는 nr, nc이다.
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				
				// 맵의 범위를 벗어났다면 continue
				if(!check(nr, nc)) continue;
				
				// nr, nc 위치에 아직 탐색하지 않은 음식물이 존재한다면
				if(map[nr][nc] == 1) {
					// 탐색했음 처리를 하고(2로 바꾸기)
					map[nr][nc] = 2;
					// q에 넣어준다.
					q.add(new int[] {nr, nc});
					// 음식물의 크기도 1 늘려준다.
					size++;
				}
			}
			
		}
		
		max = Math.max(max, size);
		
	}
	
	// 맵의 범위를 벗어났는지 확인할 함수
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
