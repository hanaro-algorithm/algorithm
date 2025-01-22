import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17179_케이크자르기 {
	static int M;
	static int [] cake;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 자르는 횟수가 담긴 목록의 길이
		int N = Integer.parseInt(st.nextToken());
		// 자를 수 있는 지점의 수
		M = Integer.parseInt(st.nextToken());
		// 롤 케이크의 길이
		int L = Integer.parseInt(st.nextToken());
		// 케이크 자르는 지점을 저장할 배열
		cake = new int[M+1];
		
		for (int i = 0; i < M; i++) {
			cake[i] = Integer.parseInt(br.readLine());
		}
		// 마지막 칸에는 롤케이크의 길이를 저장한다.
		cake[M] = L;
		
		for (int i = 0; i < N; i++) {
			int q = Integer.parseInt(br.readLine());
			
			// 이분탐색을 사용하여 최대 길이를 찾는다.
			int left = 1;
			int right = L;
			// 가장 작은 조각의 최댓값
			int ans = 0;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				// mid 이상의 길이를 q번 자르고 만들 수 있는지 확인한다.
				// 만들 수 있다면 ans를 갱신하고, left 값을 바꿔준다.
				if(check(mid, q)) {
					ans = mid;
					left = mid+1;
				// 만들 수 없다면 right 값을 바꿔준다.
				} else {
					right = mid-1;
				}
			}
			
			sb.append(ans+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static boolean check(int mid, int q) {
		// 케이크를 자른 지점을 저장할 변수
		// 현재 위치 - last를 계산하여 자른 케이크의 길이를 구한다.
		int last = 0;
		
		for (int i = 0; i <= M; i++) {
			// 현재 지점을 잘랐을 때, mid 길이 이상의 조각이 생긴다면 현재 지점을 자른다.
			if(cake[i]-last >= mid) {
				// 자르기 횟수를 q번 모두 사용했다면, 바로 return 해준다. (뒷부분은 자르지 않아도 조건을 만족한다.)
				if(--q < 0) return true;
				// 그 외의 경우는 last를 방금 자른 지점으로 바꿔준다.
				last = cake[i];
			}
		}
		
		// q번 자르지 못하면 false를 리턴한다.
		return false;
	}

}
