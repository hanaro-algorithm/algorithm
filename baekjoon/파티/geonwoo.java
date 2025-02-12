import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G3_1238_파티 {
	static final int INF = 1000001;
	static int N, X;
	
	static class Node implements Comparable<Node> {
		int to;
		int time;
		
		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		// time이 작은 순서로 정렬
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		// a->b 갈 때의 시간을 저장할 2차원 리스트
		List<ArrayList<Node>> list = new ArrayList<>();
		// a<-b 들어올 때의 시간을 저장할 2차원 리스트
		List<ArrayList<Node>> list2 = new ArrayList<>();
		
		// 두 리스트 모두 초기화해준다.
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			list2.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			
			// list에는 갈 때의 시간을 넣어준다.
			list.get(a).add(new Node(b, t));
			// list2에는 들어올 때의 시간을 넣어준다.
			list2.get(b).add(new Node(a, t));
		}
		
		// dist 배열에 X에서 다른 마을로 갈 때의 시간을 저장한다.
		int [] dist = dijkstra(list);
		// dist2 배열에 다른 마을에서 X로 올 때의 시간을 저장한다.
		int [] dist2 = dijkstra(list2);
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dist[i] + dist2[i]);
		}
		
		System.out.println(max);

	}

	private static int[] dijkstra(List<ArrayList<Node>> list) {
		// 한 번 최소 거리를 계산한 마을은 다시 계산하지 않기 위한 boolean 배열
		boolean [] v = new boolean[N];
		// 각 마을까지의 최소 시간을 저장할 배열
		int [] dist = new int[N];
		// 기본적으로 다른 마을로 못간다고 가정하고, INF 값을 넣어준다.
		Arrays.fill(dist, INF);
		// 자기 자신으로의 거리는 0이다.
		dist[X] = 0;
		
		// PQ를 사용하여 시간이 적게 걸리는 거리부터 계산한다.
		// PQ를 사용하면 기존 다익스트라 알고리즘의 시간 복잡도를 O(N^2) -> O(logN*M)으로 줄일 수 있다.
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;
			
			// 만약 이미 계산을 완료한 마을이라면 넘어간다.
			if(v[cur]) continue;
			v[cur] = true;
			
			// cur마을과 연결된 모든 마을을 확인해보면서
			// 아직 방문하지 않았고 시간이 단축되는 경우(a->c > a->b->c) 이를 갱신하고 pq에 넣어준다.
			for(Node next : list.get(cur)) {
				if(!v[next.to] && dist[next.to] > dist[cur] + next.time) {
					dist[next.to] = dist[cur] + next.time;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
			
		}
		
		return dist;
	}

}
