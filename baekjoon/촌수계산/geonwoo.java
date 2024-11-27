import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_2644_촌수계산 {
	static int [][] map;
	static int N, a, b;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.println(bfs());

	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean [] v = new boolean[N+1];
		q.add(a);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if(cur == b) {
					return res;
				}
				for (int j = 1; j <= N; j++) {
					if(map[cur][j] == 1 && !v[j]) {
						v[j] = true;
						q.add(j);
					}
				}
			}
			res++;
		}
		
		return -1;
		
	}

}