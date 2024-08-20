import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_21318_피아노체조 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 실수한 횟수를 누적합으로 저장할 배열
		int [] mistakes = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 직전 악보의 난이도를 저장할 변수
		int past = 0;
		for (int i = 1; i <= N; i++) {
			// 현재 악보의 난이도
			int now = Integer.parseInt(st.nextToken());
			
			// 직전 악보의 난이도가 현재 악보보다 높다면, i번째 실수를 +1 해서 담는다.
			mistakes[i] = mistakes[i-1];
			if(past > now) mistakes[i]++;
			
			// 직전 악보를 현재 악보로 갱신해준다.
			past = now;
		}
		
		// 출력을 저장할 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// 누적합 배열을 이용하여 구간의 실수 횟수를 O(1)로 구할 수 있다.
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(mistakes[end] - mistakes[start]+"\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
