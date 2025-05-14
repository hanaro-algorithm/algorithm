import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S4_11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 사용할 동전들을 저장할 list
		List<Integer> list = new ArrayList<>();
		
		// 동전을 입력 받으면서 K보다 작거나 같은 동전들만 list에 넣어준다.
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(K >= a) list.add(a);
		}
		
		// 오름차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		int ans = 0;
		
		while (K > 0) {
			// list의 동전들을 모두 확인해본다.
			for (int a : list) {
				// 동전 a가 남은 금액 K보다 높으면 다음 동전을 사용한다.
				if (K < a) continue;
				
				// 같은 동전을 여러번 사용해야 할 수 있으므로 한 번에 처리한다.
				// 예를 들어 K가 4200, a가 1000이면 불필요한 연산을 줄이기 위해
				// 1000원 동전을 한 번에 4개 사용한다.
				ans += K/a;
				K %= a;
				
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}
