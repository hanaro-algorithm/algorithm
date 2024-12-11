import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S2_30804_과일탕후루 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		int [] fruit = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(fruit[0], 1);
		
		int left = 0;
		int right = 0;
		int now = -1;
		
		while(left != N-1 || right != N-1) {
			if(right != N-1 && (map.size() < 2 || map.containsKey(fruit[right+1]))) {
				now = fruit[++right];
				
				map.putIfAbsent(now, 0);
				map.put(now, map.get(now)+1);
			} else {
				now = fruit[left++];
				
				if(map.get(now) == 1) map.remove(now);
				else map.put(now, map.get(now)-1);
			}	
			
			ans = Math.max(ans, right-left+1);
			
		}
		
		System.out.println(ans);
		
	}

}
