import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 확장자가 몇 개 있는지 저장할 map
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// '.'으로 split 하려면 앞에 \\를 붙여야 제대로 인식된다.
			String [] arr = str.split("\\.");
			String extension = arr[1];
			
			// 확장자가 한 번도 등장하지 않았으면 map에 추가하고, value를 +1 해준다.
			map.putIfAbsent(extension, 0);
			map.put(extension, map.get(extension)+1);
		}
		
		// map의 keySet으로 list를 생성하고, 사전 순으로 정렬한다.
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		// sb에 확장자이름, 파일의 수를 쌓는다.
		for(String extension : list) {
			sb.append(extension+" "+map.get(extension)+"\n");
		}
		
		// 정답 출력
		if(sb.length() > 0) {
			sb.setLength(sb.length()-1);
		}
		System.out.println(sb.toString());
		
	}

}
