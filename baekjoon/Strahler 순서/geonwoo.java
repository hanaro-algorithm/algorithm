import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_9470_Strahler순서 {
	static int max;
	static int [] cnt, maxOrder, maxCnt;
	static List<ArrayList<Integer>> list;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			max = 0;
			// 몇번 들어와야 하는지(0이 되면 큐에 넣기)
			cnt = new int[M+1];
			// 들어온 순서중 가장 큰 값
			maxOrder = new int[M+1];
			// 최댓값 값이 몇번 들어왔는지
			maxCnt = new int[M+1];
			list = new ArrayList<>();
			
			for (int i = 0; i <= M; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				cnt[b]++;
			}
			
			q = new ArrayDeque<>();
			
			for (int i = 1; i <= M; i++) {
				if(cnt[i] == 0) {
					maxOrder[i] = 1;
					q.add(i);
				}
			}
			
			solve();
			
			sb.append(t+" "+max+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void solve() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			max = Math.max(max, maxOrder[cur]);
			
			for(int next: list.get(cur)) {
				if(maxOrder[cur] > maxOrder[next]) {
					maxOrder[next] = maxOrder[cur];
					maxCnt[next] = 1;
				} else if(maxOrder[cur] == maxOrder[next]) {
					maxCnt[next]++;
				}
				
				cnt[next]--;
				
				if(cnt[next] == 0) {
					if(maxCnt[next] >= 2) maxOrder[next]++;
					q.add(next);
				}
				
			}
			
		}
		
	}

}
