import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S4_9372_상근이의여행 {
	static List<ArrayList<Integer>> list;
	static Set<Integer> v;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 국가의 연결 상태를 저장하기 위한 ArrayList
			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			// 국가를 방문했는지 여부를 저장하기 위한 Set
			v = new HashSet<>();
			// 탑승한 비행기의 수
			ans = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 양방향으로 연결한다.
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			// 시작점이 따로 주어지지 않았기 때문에, 아무곳이나 한 점을 잡고 bfs를 사용한다.
			for (int i = 1; i <= N; i++) {
				if(list.get(i).size() > 0) {
					bfs(i);
					break;
				}
			}
			
			sb.append(ans+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		v.add(start);
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// cur 나라에서 갈 수 있는 모든 국가를 확인해본다.
			for(int next : list.get(cur)) {
				// next 나라를 아직 방문하지 않았다면, ans를 +1 해주고 방문처리 후 q에 넣어준다.
				if(!v.contains(next)) {
					ans++;
					v.add(next);
					q.add(next);
				}
			}
		}
		
	}

}
