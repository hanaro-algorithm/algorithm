import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G2_1167_트리의지름 {
	static class Node {
		int e;
		int dist;
		
		public Node(int e, int dist) {
			this.e = e;
			this.dist = dist;
		}
	}
	
	static int max, maxNode;
	static List<ArrayList<Node>> list;
	static boolean [] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		v = new boolean[N+1];
		
		// 이중 연결 리스트 초기화
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		// 각 정점의 연결 상태를 저장한다.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				
				if(e == -1) break;
				
				int dist = Integer.parseInt(st.nextToken());
				
				list.get(V).add(new Node(e, dist));
			}
		}
		
		// dfs를 사용하여 임의의 점(1번 정점)부터 제일 먼 거리의 정점을 찾는다.
		dfs(1, 0);
		
		// visit 배열을 초기화하고, dfs를 사용하여 제일 먼 정점 maxNode부터 제일 먼 정점의 거리를 찾는다.
		v = new boolean[N+1];
		dfs(maxNode, 0);
		
		System.out.println(max);
		
	}

	private static void dfs(int e, int sum) {
		// 정점 e에 도달했을 때 max보다 크다면 제일 먼 거리와 정점을 갱신한다.
		if(sum > max) {
			max = sum;
			maxNode = e;
		}
		
		// 정점 e 방문처리
		v[e] = true;
		
		// 정점 e와 연결된 정점중에서, 방문하지 않은 정점을 방문하며 거리를 확인해본다.
		for (int i = 0; i < list.get(e).size(); i++) {
			Node next = list.get(e).get(i);
			
			// 방문했던 정점은 넘어간다.
			if(v[next.e]) continue;
			
			// 방문하지 않았다면 방문처리 후 해당 정점까지의 거리를 확인해본다.
			v[next.e] = true;
			dfs(next.e, sum + next.dist);
		}
		
	}

}
