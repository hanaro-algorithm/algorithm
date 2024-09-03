import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_S2_2002_추월 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
        // 차량번호, 순서를 넣어서 해당 차량이 몇번쨰로 들어갔는지 저장한다.
		Map<String, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			String car = br.readLine();
			map.put(car, i);
		}
		
        // 나온 차량의 순서대로, 들어갔을 때의 번호를 저장한다.
		int [] out = new int[N];
		
		for (int i = 0; i < N; i++) {
			String car = br.readLine();
			out[i] = map.get(car);
		}
		
		// 순서가 어긋났다면, 해당 차량은 추월한것이다.
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < out.length; j++) {
				if(out[i]>out[j]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}