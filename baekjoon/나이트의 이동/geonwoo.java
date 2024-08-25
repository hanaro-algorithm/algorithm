import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7562_나이트의이동 {
	static boolean [][] v;
	static int L, ans, er, ec;
	// 8가지 방향
	static int [] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int [] dc = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			L = Integer.parseInt(br.readLine());
			// 방문했었는지 여부를 저장할 2차원 배열
			v = new boolean[L][L];
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			// 시작점과 도착점이 같으면 0칸 움직이면 된다.
			if(sr == er && sc == ec) {
				sb.append(0+"\n");
				continue;
			}
			
			// BFS를 사용한다.
			bfs(sr, sc);
			
			sb.append(ans+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void bfs(int sr, int sc) {
		// sr, sc부터 시작하여 bfs로 갈 수 있는 모든 지점을 방문해본다.
		Queue<int []> q = new ArrayDeque<>();
		v[sr][sc] = true;
		q.add(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				
				for (int d = 0; d < 8; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					// 범위를 벗어나면 continue
					if(!check(nr, nc)) continue;
					
					// 도착 지점에 도착하면 종료한다.
					if(nr == er && nc == ec) {
						ans++;
						return;
					}
					
					// nr, nc에 방문한 적이 없다면 q에 넣어준다.
					if(!v[nr][nc]) {
						q.add(new int[] {nr, nc});
						v[nr][nc] = true;
					}
					
				}
			}
			
			// 큐의 사이즈만큼 확인했으면 ans+1 해준다.
			ans++;
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<L && c>=0 && c<L;
	}

}
