import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S1_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구간동안 특정 원소가 몇 개 들어있는지 저장할 map
		Map<Integer, Integer> map = new HashMap<>();
		
		// 최장 연속 부분 수열의 길이를 저장할 변수
		int max = 1;
		// 구간의 첫 원소의 idx를 저장할 변수
		int left = 0;
		// 구간의 마지막 원소의 idx를 저장할 변수
		int right = 0;
		
		// 투포인터 알고리즘 사용
		while(right < N) {
			int newNum = nums[right];
			
			map.putIfAbsent(newNum, 0);
			
			// 새로운 원소를 구간에 넣었을 때, 해당 원소의 개수가 K개를 넘어서는 경우
			if(map.get(newNum) >= K) {
				// 구간의 첫 원소를 map에서 1 빼고, leftIdx를 +1 증가시킨다.
				int oldNum = nums[left];
				map.put(oldNum, map.get(oldNum)-1);
				left++;
			// 그 외의 경우에는 새로운 원소를 구간에 넣어도 조건을 만족한다.
			} else {
				// map에 새로운 원소의 개수를 1 증가시킨다.
				map.put(newNum, map.get(newNum)+1);
				// 최장 연속 부분 수열의 길이를 갱신한다.
				max = Math.max(max, right-left+1);
				// 다음 새로운 원소를 구간에 넣기 위해 rightIdx를 +1 증가시킨다.
				right++;
			}
			
		}
		
		System.out.println(max);
		
	}

}
