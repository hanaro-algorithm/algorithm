import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S3_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 영단어가 몇 번 등장했는지 저장할 맵
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// 길이가 M보다 짧으면 map에 저장하지 않는다.
			if (str.length() < M)
				continue;

			map.putIfAbsent(str, 0);
			map.put(str, map.get(str) + 1);
		}

		// 단어의 순서를 지정해주기 위한 list, map의 keySet을 사용한다.
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			int val1 = map.get(o1);
			int val2 = map.get(o2);

			// 자주 나오는 단어일수록 앞에 배치한다.
			if (val1 != val2) {
				return Integer.compare(val2, val1);
			// 길이가 길수록 앞에 배치한다.
			} else if (o1.toString().length() != o2.toString().length()) {
				return Integer.compare(o2.toString().length(), o1.toString().length());
			// 사전순으로 배치한다.
			} else {
				return o1.toString().compareTo(o2.toString());
			}
		});
		
		// map은 더이상 사용하지 않기 때문에 정리한다.
		map.clear();

		StringBuilder sb = new StringBuilder();

		// list 순서대로 StringBuilder에 담고 출력한다.
		for (String str : list) {
			sb.append(str).append('\n');
		}

		if (sb.length() > 0) {
			sb.setLength(sb.length()-1);
		}
		
		System.out.println(sb.toString());

	}

}