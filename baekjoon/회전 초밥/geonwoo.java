import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_G4_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int [] dishes = new int[N+K];
		
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < K; i++) {
			dishes[i+N] = dishes[i];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < K; i++) {
			map.putIfAbsent(dishes[i], 0);
			map.put(dishes[i], map.get(dishes[i])+1);
		}
		
		int max = map.size();
		if(!map.containsKey(C)) max++;
		
		for (int i = K; i < N+K ; i++) {
			int left = i-K;
			
			map.putIfAbsent(dishes[i], 0);
			map.put(dishes[i], map.get(dishes[i])+1);
			
			map.put(dishes[left], map.get(dishes[left])-1);
			if(map.get(dishes[left]) == 0) map.remove(dishes[left]);
			
			int size = map.size();
			if(!map.containsKey(C)) size++;
			
			max = Math.max(max, size);
		}
		
		System.out.println(max);

	}

}
