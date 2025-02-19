import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_G5_7490_0만들기 {
	static int N;
	static List<String> list;
	static char [] sign = {'+', '-', ' '};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = scann.nextInt();
		
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			list = new ArrayList<>();
			
			dfs(0, "");
			
			Collections.sort(list);
			
			for(String s : list) {
				sb.append(s+"\n");
			}
			
			sb.append("\n");
		}
		
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());

	}

	private static void dfs(int depth, String str) {
		if(depth == N-1) {
			str += N;
			
			if(cal(str) == 0) {
				list.add(str);
			}
			
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			dfs(depth+1, str+(depth+1)+sign[i]);
		}
		
	}

	private static int cal(String str) {
		str = str.replaceAll(" ", "");
		
		// str, delim, returnDelim
		// str을 delim 기준으로 나눔. returnDelim이 true면 delim도 token으로 사용함.
		StringTokenizer st = new StringTokenizer(str, "+|-", true);
		int sum = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			
			if(s.equals("+")) {
				sum += Integer.parseInt(st.nextToken());
			} else {
				sum -= Integer.parseInt(st.nextToken());
			}
		}
		
		return sum;
	}

}
