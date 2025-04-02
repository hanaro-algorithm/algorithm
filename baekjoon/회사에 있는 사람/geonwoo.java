import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S5_7785_회사에있는사람 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			String comm = st.nextToken();
			
			if(comm.equals("enter")) {
				set.add(str);
			} else if(comm.equals("leave")) {
				set.remove(str);
			}
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		for (String str : list) {
			sb.append(str+"\n");
		}
		
		if(sb.length() > 0) {
			sb.setLength(sb.length()-1);
		}
		
		System.out.println(sb.toString());
		
	}

}
