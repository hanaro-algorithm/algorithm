import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S2_15787_기차가어둠을헤치고은하수를 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			
			if(a == 1) {
				int c = Integer.parseInt(st.nextToken())-1;
				int seat = (int) Math.pow(2, c);
				
				arr[b] = arr[b] | seat;
			} else if(a == 2) {
				int c = Integer.parseInt(st.nextToken())-1;
				int seat = (int) Math.pow(2, c);
				
				arr[b] = arr[b] & (~seat);
			} else if(a == 3) {
				arr[b] = (arr[b] << 1) % (int) Math.pow(2, 20); 
			} else {
				arr[b] = arr[b] >> 1;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(arr[i]);
		}
		
		System.out.println(set.size());
	}

}
