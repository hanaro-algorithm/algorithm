import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2583_영역구하기 {
	static int N, M;
	static int [][] map;
	static List<Integer> list;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			for (int j = r1; j < r2; j++) {
				for (int k = c1; k < c2; k++) {
					map[j][k] = -1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != -1) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int n : list) {
			sb.append(n+" ");
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		
		System.out.println(list.size());
		System.out.println(sb.toString());
		
	}

	private static void bfs(int sr, int sc) {
		Queue<int []> q = new ArrayDeque<>();
		map[sr][sc] = -1;
		q.add(new int[] {sr, sc});
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			cnt++;
			
			for (int d = 0; d < 4; d++) {
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				
				if(!check(nr, nc) || map[nr][nc] == -1) continue;
				
				map[nr][nc] = -1;
				q.add(new int[] {nr, nc});
			}
		}
		
		list.add(cnt);
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
