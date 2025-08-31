import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_15927_회문은회문아니야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int ans = 0;
		
		StringBuilder sb = new StringBuilder(s).reverse();
		
		// 2. s가 팰린드롬인 경우
		if(s.equals(sb.toString())) {
			// 길이가 1이면 항상 팰린드롬이다.
			if(s.length() == 1) ans = -1;
			
			// 같은 문자로 이루어져있는지 확인한다.
			boolean check = true;
			
			for (int i = 1; i <= s.length()-1; i++) {
				if(s.charAt(0) != s.charAt(i)) {
					check = false;
					break;
				}
			}
			
			// 3. 같은 문자로 이루어져 있으면 항상 팰린드롬이다.
			if(check) ans = -1;
			// 4. 같은 문자로 이루어진게 아니라면, 팰린드롬에서 맨앞이나 맨뒤를 빼면 항상 팰린드롬이 아니다.
			else ans = s.length()-1;
			
		// 1. s 자체가 팰린드롬이 아닌 경우
		} else {
			ans = s.length();
		}
		
		System.out.println(ans);
		
	}

}
