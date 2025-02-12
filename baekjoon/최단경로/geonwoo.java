import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1753_최단경로 {
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static final int INF = 1000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine())-1;
		List<ArrayList<Node>> list = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken())-1;
			int u = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			list.get(v).add(new Node(u, cost));
		}
		
		int [] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean [] v = new boolean[V];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;
			
			if(v[cur]) continue;
			v[cur] = true;
			
			for(Node next : list.get(cur)) {
				if(!v[next.to] && dist[next.to] > dist[cur] + next.cost) {
					dist[next.to] = dist[cur] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < V; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]+"\n");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}