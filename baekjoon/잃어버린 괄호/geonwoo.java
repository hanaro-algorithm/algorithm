import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int ans = 0;
		
		String str = br.readLine();
		
		boolean minus = false;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c != '+' && c != '-') {
				sb.append(c);
			} else {
				int num = Integer.parseInt(sb.toString());
				sb.setLength(0);
				
				if(minus) {
					ans -= num;
				} else {
					ans += num;
					
					if(c == '-') minus = true;
				}
			}
		}
		
		if(minus) ans -= Integer.parseInt(sb.toString());
		else ans += Integer.parseInt(sb.toString());
		
		System.out.println(ans);
		
	}

}
