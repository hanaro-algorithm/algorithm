import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S3_1270_전쟁_땅따먹기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		testcase:
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int T = Integer.parseInt(st.nextToken());
				
				if(T == 0) {
					sb.append("SYJKGW\n");
					continue;
				}
				
				Map<Long, Integer> map = new HashMap<>();
				
				for (int j = 0; j < T; j++) {
					Long n = Long.parseLong(st.nextToken());
					
					map.put(n, map.getOrDefault(n, 0)+1);
				}
				
				for(Map.Entry<Long, Integer> entry : map.entrySet()) {
					if(entry.getValue()*2 > T) {
						sb.append(entry.getKey()+"\n");
						continue testcase;
					}
				}
				
				sb.append("SYJKGW\n");
			}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
