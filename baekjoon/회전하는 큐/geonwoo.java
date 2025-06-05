import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_S3_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		
		int ans = 0;
		
		int [] arr = new int[M];
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			int idx = q.indexOf(arr[i]);
			int half = q.size() / 2;
			
			if(q.size() % 2 == 0) half--;
			
			if(idx <= half) {
				for (int j = 0; j < idx; j++) {
					int tmp = q.pollFirst();
					q.addLast(tmp);
					ans++;
				}
			} else {
				for (int j = 0; j < q.size() - idx; j++) {
					int tmp = q.pollLast();
					q.addFirst(tmp);
					ans++;
				}
			}
			
			q.pollFirst();
		}
		
		System.out.println(ans);

	}

}