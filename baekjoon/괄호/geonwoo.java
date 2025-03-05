import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			int cnt = 0;
			boolean check = true;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == '(') cnt++;
				else if(--cnt < 0) {
					check = false;
					break;
				}
			}
			
			if(cnt != 0) check = false;
			
			if(check) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
