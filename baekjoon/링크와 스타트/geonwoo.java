import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_15661_링크와스타트 {
	static int N, ans;
	static int [][] scores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = Integer.MAX_VALUE;
		
		N = Integer.parseInt(br.readLine());
		scores = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bitMask();
		
		System.out.println(ans);

	}

	private static void bitMask() {
		// 1팀을 저장할 리스트
		List<Integer> list1 = new ArrayList<>();
		// 2팀을 저장할 리스트
		List<Integer> list2 = new ArrayList<>();
		
		// 1부터 2^N-1까지 모든 경우의 수를 확인해본다.
		for (int i = 1; i < (1 << N)-1; i++) {
			// 두 팀 능력치의 차이가 0이면 더이상 계산하지 않아도 된다.
			if(ans == 0) return;
			
			// 0~N-1번 멤버의 팀을 나눈다.
			for (int j = 0; j < N; j++) {
				// 숫자 i를 이진수로 바꿨을 때, 뒤에서 j번째 자릿수가 1이면 list1에 넣는다.
				if((i & (1 << j)) != 0) {
					list1.add(j);
				// 그 외에는 list2에 넣는다.
				} else {
					list2.add(j);
				}
			}
			
			// 각 팀에는 한 명 이상 존재해야 한다.
			if(list1.size() != 0 && list2.size() != 0) {
				// 나눈 팀을 기준으로 두 팀 능력치의 차이를 계산한다.
				cal(list1, list2);				
			}
			
			list1.clear();
			list2.clear();
			
		}
		
	}

	private static void cal(List<Integer> list1, List<Integer> list2) {
		int len1 = list1.size();
		int len2 = list2.size();
		int sum1 = 0;
		int sum2 = 0;
		
		// 1팀 능력치 합 계산
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len1; j++) {
				sum1 += scores[list1.get(i)][list1.get(j)];
			}
		}
		
		// 2팀 능력치 합 계산
		for (int i = 0; i < len2; i++) {
			for (int j = 0; j < len2; j++) {
				sum2 += scores[list2.get(i)][list2.get(j)];
			}
		}
		
		// 능력치 차 계산 후 ans 갱신
		ans = Math.min(ans, Math.abs(sum1 - sum2));
		
	}

}
