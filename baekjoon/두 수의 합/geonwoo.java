import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_3273_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int X = Integer.parseInt(br.readLine());
		
		// 양의 정수를 작은 순서부터 정렬한다.
		Arrays.sort(arr);
		
		// a1+a2=X를 만족하는 쌍의 개수
		int ans = 0;
		// 투포인터 알고리즘 사용
		// leftIdx(a1의 arr에서 idx)는 0부터 시작한다.
		int left = 0;
		// rightIdx(a2의 arr에서 idx)는 N-1부터 시작한다.
		int right = N-1;
		
		// a1과 a2가 같아지면 종료한다.
		while(left < right) {
			int a1 = arr[left];
			int a2 = arr[right];
			int sum = a1 + a2;
			
			// 두수의 합이 X와 같으면 ans를 +1 해주고, leftIdx를 1 늘려준다.
			if(sum == X) {
				ans++;
				left++;
			// 두수의 합이 X보다 작으면 leftIdx를 1 늘려준다. (sum을 더 크게 하기 위해)
			} else if(sum < X) {
				left++;
			// 두수의 합이 X보다 크면 rightIdx를 1 줄여준다. (sum을 더 작게 하기 위해)
			} else if(sum > X) {
				right--;
			}
		}
		
		System.out.println(ans);
		
	}

}
