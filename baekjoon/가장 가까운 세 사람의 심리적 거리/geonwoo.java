import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_20529_가장가까운세사람의심리적거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N >= 33) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				sb.append(0+"\n");
				continue;
			}
			
			String [] mbti = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			int min = Integer.MAX_VALUE;
			
			outer:
				for (int i = 0; i < N; i++) {
					for (int j = i+1; j < N; j++) {
						for (int l = j+1; l < N; l++) {
							min = Math.min(min, getScore(mbti[i], mbti[j], mbti[l]));
							
							if(min == 0) break outer;
						}
					}
				}
			
			sb.append(min+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static int getScore(String str1, String str2, String str3) {
		int score = 0;
		
		for (int i = 0; i < 4; i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			char c3 = str3.charAt(i);
			
			if(c1 != c2) score++;
			if(c1 != c3) score++;
			if(c2 != c3) score++;
		}
		
		return score;
	}

}
