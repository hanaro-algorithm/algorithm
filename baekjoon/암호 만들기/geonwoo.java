import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759_암호만들기 {
	
	static char [] p;
	static int L, C;
	static char [] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 알파벳을 저장할 배열
			p = new char [C];
			// 암호들을 저장할 배열
			arr = new char [L];
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < C; i++) {
				p[i] = st.nextToken().charAt(0);
			}
			
			// 사전순으로 정렬한다.
			Arrays.sort(p);
			
			// 조합을 사용하여 모든 경우의 수를 확인해본다.
			combi(0, 0);
			
			if(sb.length() > 0) sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		
	}

	private static void combi(int cnt, int start) {
		if(cnt == L) {
			// 한개의 모음, 두개의 자음을 만족하지 못하면 암호가 될 수 없다.
			if(zeromouem()) return;
			for (int i = 0; i < L; i++) {
				sb.append(arr[i]);
			}
			sb.append("\n");
			return ;
		}
		
		for (int i = start; i < C; i++) {
			arr[cnt] = p[i];
			combi(cnt+1, i+1);
		}
		
	}

	private static boolean zeromouem() {
		int mo = 0;
		int ja = 0;
		for (int i = 0; i < L; i++) {
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				mo++;
			} else ja++;
		} 
		return (mo == 0) || (ja<2);
	}

}