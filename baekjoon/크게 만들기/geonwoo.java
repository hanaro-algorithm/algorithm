import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G3_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		int cnt = K;
		
		for (int i = 0; i < N; i++) {
			int n = s.charAt(i) - '0';
			
			// 스택이 비어있지 않고, i번째 숫자가 스택 안의 숫자보다 더 크고, 지울수 있는 갯수가 남아있다면
			// 스택에 있는 숫자를 지우고 지운 갯수를 카운팅한다.
			while(!deq.isEmpty() && deq.peekLast() < n && cnt > 0) {
				deq.pollLast();
				cnt--;
			}
			// 지울 수 있는 갯수를 모두 사용했거나 새로 들어온 수가 더 작다면 그냥 add 해준다.
			deq.add(n);
		}
		
		// K개는 무조건 지워야 하므로 K개만큼 pop해서 지운다.
		if (cnt > 0) {
			while (cnt > 0) {
				deq.pollLast();
				cnt--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!deq.isEmpty()) {
			sb.append(deq.pollFirst());
		}
		
		System.out.println(sb.toString());

	}

}
