import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_S1_1283_단축키지정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();

		outer:
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				String [] words = str.split(" ");

				for (int j = 0; j < words.length; j++) {
					// 첫글자 먼저 확인
					String s = String.valueOf(words[j].charAt(0));
					int idx = 0;
					
					if (!set.contains(s.toUpperCase())) {
						set.add(s.toUpperCase());
						
						for (int k = 0; k < j; k++) {
							idx += words[k].length();
							if (idx != 0) idx++;
						}
						
						sb.append(str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx+1) + "\n");
						continue outer;
					}
				}
				
				// 모든 글자 확인
				for (int j = 0; j < str.length(); j++) {
					String s = String.valueOf(str.charAt(j));
					
					if (!s.equals(" ") && !set.contains(s.toUpperCase())) {
						set.add(s.toUpperCase());
						
						sb.append(str.substring(0, j) + "[" + str.charAt(j) + "]" + str.substring(j+1) + "\n");
						continue outer;
					}
				}
				
				// 지정할 수 없으면 그대로 출력
				sb.append(str+"\n");
			}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}