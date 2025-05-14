import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			stack1.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char c1 = st.nextToken().charAt(0);
			
			switch (c1) {
			case 'L':
				if(stack1.isEmpty()) continue;
				
				stack2.push(stack1.pop());
				
				break;
				
			case 'D':
				if(stack2.isEmpty()) continue;
				
				stack1.push(stack2.pop());
				
				break;

			case 'B':
				if(stack1.isEmpty()) continue;
				
				stack1.pop();
				
				break;
				
			case 'P':
				char c2 = st.nextToken().charAt(0);
				
				stack1.push(c2);
				
				break;
			
			default:
				break;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		
		while (!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		
		System.out.println(sb.toString());

	}

}
