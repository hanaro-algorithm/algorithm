import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 듣도 못한 사람을 저장할 set
		Set<String> set1 = new HashSet<>();
		// 보도 못한 사람을 저장할 set
		Set<String> set2 = new HashSet<>();
		// 듣보잡을 저장할 list
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			set1.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			set2.add(br.readLine());
		}
		
		// N이 더 작은 경우 set1을 전체 순회하면서 set2에 같은 사람이 존재하는지 확인한다.
		if(N <= M) {
			for(String str : set1) {
				if(set2.contains(str)) ans.add(str);
			}
			
		// N이 더 큰 경우 set2를 전체 순회하면서 set1에 같은 사람이 존재하는지 확인한다.
		} else if(N > M) {
			for(String str : set2) {
				if(set1.contains(str)) ans.add(str);
			}
		}
		
		// 사전순으로 정렬한다.
		Collections.sort(ans);
		
		StringBuilder sb = new StringBuilder();
		// 먼저 듣보잡의 수를 쌓는다.
		sb.append(ans.size()+"\n");
		
		// 듣보잡을 한 명씩 쌓는다.
		for (String name : ans) {
			sb.append(name+"\n");
		}
		
		// 정답 출력
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
