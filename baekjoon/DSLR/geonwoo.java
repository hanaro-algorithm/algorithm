import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_9019_DSLR {
	
	static class Register {
		int n;
		String comm;
		
		public Register(int n, String comm) {
			this.n = n;
			this.comm = comm;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean [] v = new boolean[10000];
			
			Queue<Register> q = new ArrayDeque<>();
			q.offer(new Register(A, ""));
			
			while(!q.isEmpty()) {
				Register cur = q.poll();
				
				if(cur.n == B) {
					sb.append(cur.comm+"\n");
					break;
				}
				
				int n = cur.n;
				int d = (n * 2) % 10000;
				int s = n == 0 ? 9999 : n - 1;
				int l = n % 1000 * 10 + n / 1000;
				int r = n % 10 * 1000 + n / 10;
				
				if(!v[d]) {
					q.add(new Register(d, cur.comm + "D"));
					v[d] = true;
				}
				
				if(!v[s]) {
					q.add(new Register(s, cur.comm + "S"));
					v[s] = true;
				}
				
				if(!v[l]) {
					q.add(new Register(l, cur.comm + "L"));
					v[l] = true;
				}
				
				if(!v[r]) {
					q.add(new Register(r, cur.comm + "R"));
					v[r] = true;
				}
				
			}
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

}