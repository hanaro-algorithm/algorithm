import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_7795_먹을것인가먹힐것인가 {
	static int M, ans;
	static int [] arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// A를 담을 배열1
			int [] arr1 = new int[N];
			// B를 담을 배열2
			arr2 = new int[M];			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			// 배열2를 오름차순으로 정렬한다.
			Arrays.sort(arr2);
			ans = 0;
			
			// 배열1에서 숫자 1개씩 꺼내보며 배열2에 해당 숫자보다 작은 수가 몇갠지 찾는다. (이분탐색)
			for (int i = 0; i < N; i++) {
				find(arr1[i]);
			}
			
			sb.append(ans+"\n");
			
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void find(int target) {
		int left = 0;
		int right = M-1;
		int cnt = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			// target보다 작은 숫자를 발견하면, 그만큼 cnt를 갱신하고 더 큰 숫자를 찾는다.
			if(target > arr2[mid]) {
				cnt = mid+1;
				left = mid+1;
			// target보다 같거나 큰 숫자를 발견하면, 더 작은 숫자를 찾는다.
			} else if(target <= arr2[mid]) {
				right = mid-1;
			}
		}
		
		ans += cnt;
		
	}

}
