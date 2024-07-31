import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer [] ropes = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		// 로프가 정렬이 되어있지 않을 수 있으므로 큰 순서대로 정렬한다.
		Arrays.sort(ropes, Collections.reverseOrder());
		
		// 최대 중량을 저장할 변수
		int max = 0;
		
		// 들어올릴 수 있는 중량이 높은 로프부터 하나씩 모두 사용해본다.
		for (int i = 0; i < N; i++) {
			// i번째 로프가 들어올릴 수 있는 중량은 m이다.
			int rope = ropes[i];
			// i번째 로프를 사용한다는 것은, 이전까지의 로프를 포함하여 총 (i+1)개를 사용한다는 것이다.
			// k개의 로프를 사용하면 각각의 로프에는 w/k 만큼의 중량이 걸린다. (w는 최대 무게)
			// w/k = m일 때 최대치를 사용하는 것이므로, w = m*k가 된다. 따라서 max와 rope * (i+1)을 비교한다.
			max = Math.max(max, rope * (i+1));
		}
		
		System.out.println(max);
		
	}

}
