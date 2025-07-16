import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_6497_전력난 {
	static class Road implements Comparable<Road> {
		int a;
		int b;
		int weight;
		
		public Road(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N, M;
	static int [] parent;
	static PriorityQueue<Road> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			parent = new int[M];
			
			for (int i = 0; i < M; i++) {
				parent[i] = i;
			}
			
			pq = new PriorityQueue<>();
			int total = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				pq.add(new Road(a, b, weight));
				total += weight;
			}
			
			int sum = kruskal();
			
			sb.append((total-sum)+"\n");
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static int kruskal() {
		int sum = 0;
		int cnt = 0;
		
		while (cnt < M-1) {
			Road cur = pq.poll();
			
			int a = cur.a;
			int b = cur.b;
			
			if(find(a) == find(b)) continue;
			
			union(a, b);
			
			sum += cur.weight;
			cnt++;
		}
		
		return sum;
	}

	private static void union(int a, int b) {
		a = parent[a];
		b = parent[b];
		
		parent[a] = b;
	}

	private static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}

}
