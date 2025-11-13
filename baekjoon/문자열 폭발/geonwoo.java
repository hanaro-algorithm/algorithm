import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_G4_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> combos = new Stack<Integer>();
		
		String str = br.readLine();
		String boom = br.readLine();
		
		int combo = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			stack.add(c);
			
			if(c == boom.charAt(combo)) {
				combo++;
				if(combo == boom.length()) {
					for (int j = 0; j < combo; j++) {
						stack.pop();
					}
					if(combos.size() > 0) {
						combo = combos.pop();
					} else {
						combo = 0;
					}
				}
			} else if(c == boom.charAt(0)) {
				combos.add(combo);
				combo = 1;
			} else {
				combos.clear();
				combo = 0;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		String ans = sb.reverse().toString();
		if(ans.equals("")) {
			System.out.println("FRULA");
		} else {
			System.out.println(ans);
		}
		
	}

}
