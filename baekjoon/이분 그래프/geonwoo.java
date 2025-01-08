import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_1707_이분그래프 {
	static List<ArrayList<Integer>> list;
	static int [] group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<>());
			}
			
			group = new int[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			boolean flag = true;
			
			for (int i = 1; i <= V; i++) {
				if(group[i] == 0) {
					flag = bfs(i);
				}
				
				if(!flag) break;
			}
			
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		group[start] = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list.get(cur)) {
				if(group[cur] == group[next]) return false;
				
				if(group[next] == 0) {
					group[next] = group[cur] * -1;
					q.add(next);
				}
			}
		}
		
		return true;
	}

}
