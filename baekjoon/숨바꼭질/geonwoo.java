import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S1_1697_숨바꼭질 {
	static int K, ans;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		K = scann.nextInt();
		
		bfs(N);
		
		System.out.println(ans);

	}

	private static void bfs(int N) {
		boolean [] v = new boolean[100001];
		v[N] = true;
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		
		int t = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				
				if(cur == K) {
					ans = t;
					return;
				}
				
				int past = cur-1;
				if(past >= 0 && !v[past]) {
					v[past] = true;
					q.add(past);
				}
				
				int next = cur+1;
				if(next <= 100000 && !v[next]) {
					v[next] = true;
					q.add(next);
				}
				
				int future = cur*2;
				if(future <= 100000 && !v[future]) {
					v[future] = true;
					q.add(future);
				}
				
			}
			
			t++;
			
		}
		
	}

}
