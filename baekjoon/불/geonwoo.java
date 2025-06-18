import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_5427_불 {
	static int N, M;
	static char [][] map;
	static List<int []> fires;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		char symbol;
		
		public Point(int r, int c, char symbol) {
			this.r = r;
			this.c = c;
			this.symbol = symbol;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			// 불의 시작점을 저장할 리스트
			fires = new ArrayList<>();
			
			// 상근이의 시작점을 저장할 변수들
			int sr = -1;
			int sc = -1;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = s.charAt(j);
					map[i][j] = c;
					
					if(c == '@') {
						sr = i;
						sc = j;
					} else if(c == '*') {
						fires.add(new int[] {i, j});
					}
				}
			}
			
			int time = bfs(sr, sc);
			
			if(time == -1) sb.append("IMPOSSIBLE\n");
			else sb.append(time+"\n");
		
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static int bfs(int sr, int sc) {
		Queue<Point> q = new ArrayDeque<>();
		// 상근이를 먼저 큐에 넣는다.
		q.add(new Point(sr, sc, '@'));
		
		// 이후에 모든 불을 큐에 넣는다.
		for(int [] fire : fires) {
			q.add(new Point(fire[0], fire[1], '*'));
		}
		
		// 경과한 시간을 저장할 변수
		int time = 0;
		
		while(!q.isEmpty()) {
			// 초기 큐에 들어있는 사이즈만큼 진행하고 시간을 증가시킨다.
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				
				// 상근이와 불이 한 점에 동시에 도달한 경우
				// 해당 경우에는 탈출할 수 없다.
				if(cur.symbol == '@' && map[cur.r][cur.c] == '*') continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					// 상근이와 불이 특정 문자에 도달했을 때 작용하는게 다르기 때문에 분기처리함.
					if(cur.symbol == '@') {
						// 상근이가 맵 밖에 도달하면 탈출 시간을 리턴한다.
						if(!check(nr, nc)) return time+1;
						
						// 상근이가 빈 공간에 도달하면 맵에 표시하고 큐에 넣는다.
						if(map[nr][nc] == '.') {
							map[nr][nc] = '@';
							q.add(new Point(nr, nc, '@'));
						}
					} else if(cur.symbol == '*') {
						// 불이 맵 밖에 도달해도 아무 일도 일어나지 않는다. (큐에 넣지는 않음)
						if(!check(nr, nc)) continue;
						
						// 불이 빈 공간에 도달하면 맵에 표시하고 큐에 넣는다. (상근이와 동일)
						if(map[nr][nc] == '.') {
							map[nr][nc] = '*';
							q.add(new Point(nr, nc, '*'));
						// 불이 상근이가 있던 장소에 도달하면 덧씌운다. (큐에 넣지는 않음)
						// 한 점에 동시에 도달하면 탈출 할 수 없게 한다. (큐에서 꺼낼 때 검증함)
						} else if(map[nr][nc] == '@') {
							map[nr][nc] = '*';
						}
						
					}
					
				}

			}
			
			// 큐의 사이즈만큼 진행했으면 시간을 1 늘린다.
			time++;
			
		}
		
		// 모든 경우의 수를 확인했는데 탈출하지 못한 경우
		return -1;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
