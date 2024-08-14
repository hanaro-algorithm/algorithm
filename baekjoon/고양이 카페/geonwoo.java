import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_28353_고양이카페 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] cats = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cats[i] = Integer.parseInt(st.nextToken());
		}
		
		// 고양이를 가벼운 순으로 정렬한다.
		Arrays.sort(cats);
		
		int ans = 0;
		int left = 0;
		int right = N-1;
		
		// 투포인터 알고리즘 사용
		while(left < right) {
			// 남아있는 고양이들 중 가장 가벼운 고양이
			int cat1 = cats[left];
			// 남아있는 고양이들 중 가장 무거운 고양이
			int cat2 = cats[right];
			
			// 둘의 무게를 합쳐서 K가 된다면 두 마리를 데려가서 행복해질 수 있다.
			if(cat1 + cat2 <= K) {
				ans++;
				// 사용한 고양이는 다시 사용할 수 없다.
				left++;
			}
			
			// 조건의 만족여부와 상관없이 가장 무거운 고양이의 idx를 -1 해준다.
			right--;
			
		}
		
		System.out.println(ans);
		
	}

}
