import java.util.Scanner;

public class BOJ_S2_13022_늑대와올바른단어 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		String str = scann.nextLine();
		boolean ans = true;
		int cnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == 'w') cnt++;
			else {
				if(cnt == 0) {
					ans = false;
					break;
				}
				
				StringBuilder sb = appendSb(cnt);
				int len = sb.toString().length();
				
				if(len > str.substring(i).length() || !sb.toString().equals(str.substring(i, i+len))) {
					ans = false;
					break;
				}
				
				cnt = 0;
				i += len-1;
				
			}
		}
		
		if(cnt > 0) ans = false;
		
		if(ans) System.out.println(1);
		else System.out.println(0);

	}

	private static StringBuilder appendSb(int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cnt; i++) {
			sb.append('o');
		}
		
		for (int i = 0; i < cnt; i++) {
			sb.append('l');
		}
		
		for (int i = 0; i < cnt; i++) {
			sb.append('f');
		}
		
		
		return sb;
	}

}
