import java.util.Scanner;

public class BOJ_G5_16719_ZOAC {
	static int N;
	static boolean [] v;
	static String origin;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		sb = new StringBuilder();
		
		origin = scann.nextLine();
		N = origin.length();
		v = new boolean[N];
		
		dfs(0);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void dfs(int idx) {
		while(true) {
			int minIdx = -1;
			int min = 100;
			
			for (int i = idx; i < N; i++) {
				if(v[i]) continue;
				
				char c = origin.charAt(i);
				int val = c - 'A';
				
				if(val < min) {
					minIdx = i;
					min = val;
				}
			}
			
			if(minIdx == -1) break;
			
			v[minIdx] = true;
			
			String tmp = "";
			for (int i = 0; i < N; i++) {
				if(v[i]) tmp += origin.charAt(i);
			}
			
			sb.append(tmp+"\n");
			dfs(minIdx+1);
			
		}
		
	}

}
