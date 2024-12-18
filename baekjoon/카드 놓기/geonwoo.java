import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ_S4_5568_카드놓기 {
	static int N, K;
	static String [] picks, arr;
	static Set<String> set;
	static boolean [] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		picks = new String[K];
		arr = new String[N];
		set = new HashSet<String>();
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		perm(0);
		
		System.out.println(set.size());
		
	}

	private static void perm(int cnt) {
		if(cnt == K) {
			set.add(Arrays.stream(picks).collect(Collectors.joining()));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			picks[cnt] = arr[i];
			perm(cnt+1);
			v[i] = false;
		}
		
	}

}
