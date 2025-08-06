import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1976_여행가자 {
	static int [] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println("YES");
			return;
		}
		
		parent = new int[N];
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n == 0 || j <= i) continue;
				
				if(find(i) != find(j)) union(i, j);
			}
		}
		
		boolean ans = true;
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken())-1;
			
			if(find(start) != find(now)) {
				ans = false;
				break;
			}
		}
		
		if(ans) System.out.println("YES");
		else System.out.println("NO");

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		parent[a] = b;
	}

	private static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

}
