import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S3_16165_걸그룹마스터준석이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// key: 그룹이름, value: 멤버리스트를 가진 맵
		Map<String, List<String>> group = new HashMap<>();
		// key: 멤버이름, value: 그룹이름을 가진 맵
		Map<String, String> member = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			group.put(team, new ArrayList<>());
			
			int K = Integer.parseInt(br.readLine());
			for (int j = 0; j < K; j++) {
				String name = br.readLine();
				// 2개의 맵 모두 정보를 저장한다.
				member.put(name, team);
				group.get(team).add(name);
			}
			
			// 사전순으로 정렬한다.
			Collections.sort(group.get(team));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			int type = Integer.parseInt(br.readLine());
			
			// 0일 경우 멤버리스트 출력
			if(type == 0) {
				for(String name : group.get(str)) {
					sb.append(name+"\n");
				}
			// 1일 경우 그룹이름 출력
			} else if(type == 1) {
				sb.append(member.get(str)+"\n");
			}
			
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
