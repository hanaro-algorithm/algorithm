import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_4096_팰린드로미터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String num = br.readLine();
			
			if(num.equals("0")) break;
			
			int cnt = 0;
			
			while(true) {
				if(check(num)) break;
				
				int len = num.length();				
				int newNum = Integer.parseInt(num)+1;
				num = String.valueOf(newNum);
				
				if(num.length() < len) {
					StringBuilder sb2 = new StringBuilder();
					for (int i = 0; i < len - num.length(); i++) {
						sb2.append('0');
					}
					sb2.append(num);
					num = sb2.toString();
				}
				
				cnt++;
			}
			
			sb.append(cnt+"\n");
			
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static boolean check(String num) {
		for (int j = 0; j < num.length()/2; j++) {
			char c1 = num.charAt(j);
			char c2 = num.charAt(num.length()-1-j);
			
			if(c1 != c2) return false;
		}
		
		return true;
	}

}
