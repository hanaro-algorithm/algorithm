import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G2_1701_Cubeditor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int len = str.length();
		int ans = 0;
		
		for (int i = 0; i < len; i++) {
			String sub = str.substring(i, len);
			ans = Math.max(ans, check(sub));
		}
		
		System.out.println(ans);
		
	}

	private static int check(String str) {
		int r = 0;
		int len = str.length();
		int max = 0;
		int [] pi = new int[len];
		
		for (int l = 1; l < len; l++) {
			while(r > 0 && str.charAt(l) != str.charAt(r)) {
				r = pi[r-1];
			}
			
			if(str.charAt(l) == str.charAt(r)) {
				pi[l] = ++r;
				max = Math.max(max, pi[l]);
			}
		}
		
		return max;
	}

}
