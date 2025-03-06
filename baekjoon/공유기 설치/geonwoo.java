import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2110_공유기설치 {
	static int N;
	static int [] home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		home = new int[N];
		
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		int left = 1;
		int right = home[N-1] - home[0] + 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(check(mid) < C) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(left-1);
		
	}

	private static int check(int mid) {
		int cnt = 1;
		int last = home[0];
		
		for (int i = 1; i < N; i++) {
			int now = home[i];
			
			if(now - last >= mid) {
				cnt++;
				last = now;
			}
		}
		
		return cnt;
	}

}
