import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_19941_햄버거분배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		int ans = 0;
		// 이미 사람-햄버거 쌍을 이룬적이 있는지 여부를 저장할 배열
		boolean [] v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			// i번째 사람 or 햄버거를 이미 사용했다면 continue
			if(v[i]) continue;
			
			char c1 = str.charAt(i);
			
			for (int j = i+1; j <= Math.min(i+K, N-1); j++) {
				// j번째 사람 or 햄버거를 이미 사용했다면 continue
				if(v[j]) continue;
				
				char c2 = str.charAt(j);

				// i번째 요소와 j번째 요소가 같다면 continue
				if(c1 == c2) continue;
				
				// 그 외의 경우에는 사람-햄버거가 1쌍을 이루게 된다.
				v[j] = true;
				ans++;
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}
