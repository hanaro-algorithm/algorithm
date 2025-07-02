import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1062_가르침 {
	static int N, K, max;
	static int [] words;
	static boolean [] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		words = new int[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int bit = 0;
			
			for (char c : s.toCharArray()) {
				int digit = c - 'a';
				bit |= 1 << digit;
			}
			
			words[i] = bit;
		}
		
		v = new boolean[26];
		v[0] = true;
		v[2] = true;
		v[8] = true;
		v[13] = true;
		v[19] = true;
		
		combi(0, 0);
		
		System.out.println(max);
		
	}

	private static void combi(int start, int depth) {
		if(depth == K-5) {
			int cnt = 0;
			int bit = 0;
			
			for (int i = 0; i < 26; i++) {
				if(v[i]) bit |= (1 << i);
			}
			
			for (int word : words) {
				if((word & bit) == word) cnt++;
			}
			
			max = Math.max(max, cnt);
			
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			combi(i+1, depth+1);
			v[i] = false;
		}
		
	}

}
