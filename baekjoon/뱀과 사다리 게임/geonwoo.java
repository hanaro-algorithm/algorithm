import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16928_뱀과사다리게임 {
	static int N, M, ans;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map.put(x, y);
		}
		
		bfs();
		
		System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		
		boolean [] v = new boolean[101];
		v[1] = true;
		
		int turn = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				
				if(cur == 100) {
					ans = turn;
					return;
				}
				
				for (int d = 1; d <= 6; d++) {
					int next = cur+d;
					
					if(next > 100 || v[next]) continue;
					
					if(map.containsKey(next)) {
						int move = map.get(next);
						if(!v[move]) {							
							v[next] = true;
							v[move] = true;
							q.add(move);
						}
					} else {
						v[next] = true;
						q.add(next);
					}
				}
				
			}
			
			turn++;
			
		}
		
	}

}
