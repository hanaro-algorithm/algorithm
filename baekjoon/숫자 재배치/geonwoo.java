import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S1_16943_숫자재배치 {
	static int N, B;
	static Integer [] nums;
	static int [] picks;
	static boolean [] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String strA = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		
		// 정수 A의 길이를 저장할 변수
		N = strA.length();
		// A의 숫자들을 순서를 정해 저장할 배열
		picks = new int[N];
		// A의 숫자들을 사용했는지 여부를 저장할 배열
		v = new boolean[N];
		
		// A의 길이가 B보다 길면 -1을 출력하고 종료한다.
		if(N > String.valueOf(B).length()) {
			System.out.println(-1);
			System.exit(0);
		}
		
		// A의 숫자들을 저장할 배열
		nums = new Integer[strA.length()];
		for (int i = 0; i < N; i++) {
			nums[i] = strA.charAt(i) - '0';
		}
		
		// A의 숫자를 큰 순서대로 정렬한다
		Arrays.sort(nums, Collections.reverseOrder());
		
		find(0);
		
		// 모든 값을 확인해도 없으면 -1을 출력한다.
		System.out.println(-1);
		
	}

	private static void find(int cnt) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(picks[i]);
			}
			
			// 순서를 정해 새로운 수 C를 만든다.
			int n = Integer.parseInt(sb.toString());
			
			// C는 0으로 시작하면 안된다.
			if(String.valueOf(n).length() < N) return;
			
			// C가 B보다 작을 경우 가장 큰 값을 찾은 것이므로 -1 출력 후 종료한다.
			if(n < B) {
				System.out.println(n);
				System.exit(0);
			}
			
			return;
		}
		
		// A의 숫자들을 순서를 정해서 하나씩 사용한다.
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			picks[cnt] = nums[i];
			find(cnt+1);
			v[i] = false;
		}
		
	}

}
