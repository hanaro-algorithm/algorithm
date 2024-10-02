import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S4_16173_점프왕쩰리_Small {
	static int N;
	static int [][] map;
	static int [] dr = {0, 1};
	static int [] dc = {1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println("Hing");
	}

	private static void bfs() {
		Queue<int []> q = new ArrayDeque<>();
		boolean [][] v = new boolean[N][N];
		v[0][0] = true;
		q.add(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			int val = map[curR][curC];
			
			if(curR == N-1 && curC == N-1) {
				System.out.println("HaruHaru");
				System.exit(0);
			}
			
			for (int d = 0; d < 2; d++) {
				// 칸에 써인 숫자만큼 점프한다.
				int nr = curR+dr[d]*val;
				int nc = curC+dc[d]*val;
				
				if(!check(nr, nc) || v[nr][nc]) continue;
				
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
				
			}
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
