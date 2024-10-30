import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_S2_2784_가로세로퍼즐 {
	static String [] words, picks;
	static boolean [] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		words = new String[6];
		picks = new String[3];
		v = new boolean[6];
		for (int i = 0; i < 6; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words);
		
		dfs(0, 0);
		
		System.out.println(0);
		
	}

	private static void dfs(int start, int cnt) {
		if(cnt == 3) {
			char [][] arr = new char[3][3];
			for (int i = 0; i < 3; i++) {
				arr[i] = picks[i].toCharArray();
			}
			
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < 6; i++) {
				if(!v[i]) {
					map.putIfAbsent(words[i], 0);
					map.put(words[i], map.get(words[i])+1);
				}
			}
			
			boolean check = true;
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				sb.setLength(0);
				for (int j = 0; j < 3; j++) {
					sb.append(arr[j][i]);
				}
				
				if(map.containsKey(sb.toString())) {
					map.put(sb.toString(), map.get(sb.toString())-1);
					if(map.get(sb.toString()) == 0) map.remove(sb.toString());
				} else {
					check = false;
					break;
				}
				
			}
			
			if(check) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
				System.exit(0);
			}
			
			return;
		}
		
		for (int i = 0; i < 6; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			picks[cnt] = words[i];
			dfs(i+1, cnt+1);
			v[i] = false;
		}
		
	}

}
