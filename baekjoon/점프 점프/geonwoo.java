import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_14248_점프점프 {
	
	static int N, ans;
	static int [] dir = {-1, 1};
	static int [] map;
	static boolean [] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		// 돌에 적힌 숫자들을 저장할 배열
		map = new int[N];
		// 돌을 방문했는지 여부를 저장할 배열
		v = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = Integer.parseInt(br.readLine())-1;
		
		bfs(start);
		
		System.out.println(ans);
		
	}

	private static void bfs(int start) {
		v[start] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		ans++;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 왼쪽, 오른쪽 방향에 대해 찾아본다.
			for (int d = 0; d < 2; d++) {
				// 현재 돌에 적힌 숫자와 방향을 이용해서 다음 가고싶은 돌을 찾는다.
				int next = now + map[now]*dir[d];
				
				// 범위를 벗어나거나, 이미 방문한 돌이면 continue
				if(!check(next) || v[next]) continue;
				
				v[next] = true;
				q.add(next);
				ans++;
			}
		}
		
	}

	private static boolean check(int p) {
		return p >= 0 && p < N;
	}

}
