import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S4_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 숫자 카드를 몇 장 가지고 있는지를 저장하기 위한 map
		Map<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			map.putIfAbsent(n, 0);
			map.put(n, map.get(n)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(n)) {
				sb.append(map.get(n)+" ");
			} else {
				sb.append(0+" ");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
