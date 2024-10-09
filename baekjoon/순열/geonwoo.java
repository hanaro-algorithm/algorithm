import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_9742_순열 {
	static int N, M, cnt;
	static char [] arr, picks;
	static boolean [] v;
	static boolean flag;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		while((str = br.readLine()) != null) {
			sb.append(str+" = ");
			
			StringTokenizer st = new StringTokenizer(str);
			
			// 집합의 원소를 저장할 배열
			arr = st.nextToken().toCharArray();
			// 집합의 길이를 저장할 변수
			N = arr.length;
			// 집합의 원소를 순서를 정해 저장할 배열
			picks = new char[N];
			// 집합의 원소를 사용했는지 여부를 저장할 배열
			v = new boolean[N];
			// 등장하는 위치를 저장할 변수
			M = Integer.parseInt(st.nextToken());
			// 몇 번째 순서쌍인지를 저장할 변수
			cnt = 0;
			// M번째 위치의 순열을 저장할 변수
			ans = "";
			// 순열을 찾았을 때 함수를 빠져나오기 위한 변수
			flag = false;
			
			// 순열을 사용한다.
			perm(0);
			
			// 모든 경우의 수를 찾아도 M번째에 도달할 수 없는 경우
			if(ans.equals("")) {
				sb.append("No permutation\n");
			} else {
				sb.append(ans+"\n");
			}
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static void perm(int depth) {
		if(flag) return;
		
		if(depth == N) {
			cnt++;
			
			// 해당 순열이 M번째 인 경우 ans를 갱신하고 함수를 빠져나온다.
			if(cnt == M) {
				flag = true;
				ans = String.valueOf(picks);
			}
			
			return;
		}
		
		// 백트래킹 사용
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			picks[depth] = arr[i];
			perm(depth+1);
			v[i] = false;
			
		}
		
	}

}
