import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S3_1449_수리공항승 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		// 테이프로 막은 구역들을 저장할 Hashset
		Set<Integer> set = new HashSet<>();
		// 물이 새는 곳들을 저장할 배열
		int [] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());	
		}
		
		// 숫자가 작은 순으로 정렬한다.
		Arrays.sort(nums);
		
		// 물이 새는 모든 곳을 확인해본다.
		for(int n : nums) {
			// 현재 구역이 이미 막혀있다면 넘어간다.
			if(set.contains(n)) continue;
			
			// 막혀있지 않다면, 테이프르 붙여서 n부터 n+L 전까지의 구역을 막는다.
			for (int j = n; j < n+L; j++) {
				set.add(j);
			}
			
			// 테이프 사용 횟수를 증가시킨다.
			ans++;
		}
		
		System.out.println(ans);
		
	}

}
