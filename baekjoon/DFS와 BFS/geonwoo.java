import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS {
	static int N;
	static boolean [][] map;
	static boolean [] v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		map = new boolean[N+1][N+1];
		v = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		dfs(V);
		
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		v = new boolean[N+1];
		
		bfs(V);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		v[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			n = q.poll();
			sb.append(n+" ");
			
			for (int i = 1; i <= N; i++) {
				if(v[i] || !map[n][i]) continue;
				
				v[i] = true;
				q.add(i);
			}
		}
		
	}

	private static void dfs(int n) {
		sb.append(n+" ");
		v[n] = true;
		
		for (int i = 1; i <= N; i++) {
			if(v[i] || !map[n][i]) continue;
			
			v[i] = true;
			dfs(i);
		}
		
	}

}
