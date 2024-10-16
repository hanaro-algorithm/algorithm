import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_2428_표절 {
	static int N;
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 크기가 작은 순으로 정렬한다.
		Arrays.sort(arr);
		
		// 검사해야하는 쌍의 개수
		long ans = 0;
		
		for (int i = 0; i < N-1; i++) {
			// 바로 다음의 파일도 조건을 만족하지 않으면 이분탐색을 진행하지 않는다.
			if(arr[i] < 0.9 * arr[i+1]) continue;
			
			// 이외의 파일은 이분탐색으로 검사해야하는 쌍의 개수를 찾는다.
			ans += (find(i) - i);
		}
		
		System.out.println(ans);
		
	}

	private static int find(int idx) {
		int left = idx+1;
		int right = N-1;
		int ans = left;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			// mid번째 파일이 조건을 만족하면 조건을 만족하는 더 큰 파일을 찾아본다.
			if(arr[idx] >= 0.9 * arr[mid]) {
				ans = mid;
				left = mid+1;
			// 만족하지 않으면 더 작은 파일을 찾아본다.
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
	}

}
