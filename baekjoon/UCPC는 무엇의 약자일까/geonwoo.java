import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_S5_15904_UCPC는무엇의약자일까 {
	static StringBuilder sb;
	static final String UCPC = "UCPC";
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		String str = scann.nextLine();
		sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		set.add('U'); set.add('C'); set.add('P');
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(set.contains(c)) sb.append(c);
		}
		
		dfs(0, 0);
		
		System.out.println("I hate UCPC");

	}
	private static void dfs(int start, int depth) {
		if(depth == 4) {
			System.out.println("I love UCPC");
			System.exit(0);
		}
		
		for (int i = start; i < sb.toString().length(); i++) {
			if(sb.toString().charAt(i) == UCPC.charAt(depth)) {
				dfs(i+1, depth+1);
			}
		}
		
	}

}
