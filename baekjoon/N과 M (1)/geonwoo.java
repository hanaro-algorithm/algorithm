import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15649_N과M1 {
	static int N, M;
	static int [] picks;
	static boolean [] v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 선택한 숫자를 저장할 배열
		picks = new int[M];
		// 숫자를 선택했는지 여부를 저장할 배열
		v = new boolean[N+1];
		// 출력을 저장하기 위한 StringBuilder
		sb = new StringBuilder();
		
		// 순열을 찾는다.
		perm(0);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void perm(int cnt) {
		// M개의 숫자를 선택했으면 StringBuilder에 선택한 숫자들을 담는다.
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(picks[i]+" ");
			}
			
			sb.setLength(sb.length()-1);
			sb.append("\n");
			
			return;
		}
		
		// 1부터 N까지의 숫자 중 선택하지 않은 숫자를 고른다.
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				// 선택했음 처리를 한다.
				v[i] = true;
				picks[cnt] = i;
				perm(cnt+1);
				// 백트래킹을 이용해서 다시 돌아오면 선택했음 처리를 해제한다.
				v[i] = false;
			}
		}
		
	}

}
