import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S1_2531_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		// 초밥의 번호를 저장할 배열, 회전 초밥이기 때문에 K만큼 뒤에 더 붙여준다.
		int [] dishes = new int[N+K];
		
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		// K만큼 앞에 있던 초밥을 뒤에 붙여준다.
		for (int i = 0; i < K; i++) {
			dishes[i+N] = dishes[i];
		}
		
		// 0 ~ K-1번째 있는 초밥으로 초기 세팅을 해준다.
		// map에는 해당 구간 안에 무슨 초밥이 몇 개 들어있는지 저장한다.
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < K; i++) {
			map.putIfAbsent(dishes[i], 0);
			map.put(dishes[i], map.get(dishes[i])+1);
		}
		
		// 처음 구간의 최댓값을 미리 계산한다.
		int max = map.size();
		if(!map.containsKey(C)) max++;
		
		// 오른쪽 idx는 i, 왼쪽 idx는 left로 계산해서 구간이 바뀔때마다 초밥의 종류를 계산한다. (슬라이딩 윈도우/투포인터)
		for (int i = K; i < N+K ; i++) {
			int left = i-K;
			
			// 새롭게 추가되는 초밥을 map에 넣는 작업
			map.putIfAbsent(dishes[i], 0);
			map.put(dishes[i], map.get(dishes[i])+1);
			
			// 제외되는 초밥을 map에서 빼내는 과정
			map.put(dishes[left], map.get(dishes[left])-1);
			if(map.get(dishes[left]) == 0) map.remove(dishes[left]);
			
			// map의 size가 먹을 수 있는 초밥 종류의 개수이다.
			int size = map.size();
			if(!map.containsKey(C)) size++;
			
			max = Math.max(max, size);
		}
		
		System.out.println(max);

	}

}
