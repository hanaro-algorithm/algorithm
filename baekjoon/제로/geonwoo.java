import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n != 0) stack.add(n);
			else stack.pop();
		}
		
		int ans = 0;
		
		while(!stack.isEmpty()) ans += stack.pop();
		
		System.out.println(ans);
		
	}

}
