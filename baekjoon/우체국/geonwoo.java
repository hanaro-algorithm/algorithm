import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2141_우체국 {
	// 마을 위치는 1, 5, 10 고정
	// 인구가 1 3 3 일 때 -> 4: 24, 5: 19, 6: 20, 10: 24 -> 5가 유리
	// 인구가 1 3 4 일 때 -> 4: 30, 5: 24, 6: 24, 10: 24 -> 5~10가 유리
	// 인구가 1 3 5 일 때 -> 4: 36, 5: 29, 6: 28, 10: 24 -> 10이 유리
	
	// 인구의 합이 짝수인 경우 : 총 인구의 N/2 ~ N/2+1번째 사람이 살고있는 위치가 유리
	// 인구의 합이 홀수인 경우 : 총 인구의 N/2번째 사람이 살고있는 위치가 유리
	
	static class Town implements Comparable<Town> {
		int x;
		int people;
		
		public Town(int x, int people) {
			this.x = x;
			this.people = people;
		}

		@Override
		public int compareTo(Town o) {
			return Integer.compare(this.x, o.x);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 총 인구수를 저장할 변수
		long total = 0;
		// 마을들을 저장할 배열
		Town [] towns = new Town[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			
			// towns에 마을을 저장하고, total에 인구수를 추가해준다.
			towns[i] = new Town(x, people);
			total += people;
		}
		
		// 마을을 위치를 기준으로 오름차순 정렬한다.
		Arrays.sort(towns);
		// i번째 마을까지의 인구수를 저장할 변수
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			// sum에 i번째 마을 인구스를 저장한다.
			sum += towns[i].people;
			
			// sum이 total의 절반보다 같거나 커지는 순간, 해당 마을에 우체국을 설치하는게 가장 유리하다.
			// total이 홀수일 경우를 생각하여 +1한 뒤 2로 나눈 값과 비교한다.
			if((total+1)/2 <= sum) {
				System.out.println(towns[i].x);
				break;
			}
		}
		
	}

}
