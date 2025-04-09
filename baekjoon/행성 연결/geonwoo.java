import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_16398_행성연결 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][N];
		int [] dist = new int[N];
		boolean [] v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		v[0] = true;
		
		int minIdx = -1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i < N; i++) {
			dist[i] = Math.min(dist[i], arr[0][i]);
			
			if(dist[i] < min) {
				minIdx = i;
				min = dist[i];
			}
		}
		
		for (int t = 1; t < N; t++) {
			v[minIdx] = true;
			int nextIdx = minIdx;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				if(v[i]) continue;
				
				if(i == nextIdx) continue;
				
				dist[i] = Math.min(dist[i], arr[nextIdx][i]);
				
				if(dist[i] < min) {
					minIdx = i;
					min = dist[i];
				}
			}
		}
		
		long ans = 0;
		
		for (int i = 0; i < N; i++) {
			ans += dist[i];
		}
		
		System.out.println(ans);
		
	}

}
