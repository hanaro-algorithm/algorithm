import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_S4_11652_카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			Long n = Long.parseLong(br.readLine());
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		
		long minVal = Long.MAX_VALUE;
		int min = -1;
		
		for(Map.Entry<Long, Integer> entry : map.entrySet()) {
			long key = entry.getKey();
			int val = entry.getValue();
			
			if(val > min) {
				min = val;
				minVal = key;
			} else if(val == min && key < minVal) {
				minVal = key;
			}
		}
		
		System.out.println(minVal);
		
//		Collections.sort(list, (Long o1, Long o2) -> {
//			if(map.get(o1) != map.get(o2)) {
//				return Integer.compare(map.get(o2), map.get(o1));
//			}
//			
//			return Long.compare(o1, o2);
//		});
//		
//		System.out.println(list.get(0));
		
	}

}
