import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_20366_같이눈사람만들래 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 눈덩이를 저장할 배열
		int [] snow = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순으로 정렬한다.
		Arrays.sort(snow);
		
		// 엘사와 안나의 눈사람의 키차이를 저장할 변수. 초기값은 최대로 설정한다.
		int min = Integer.MAX_VALUE;
		
		outer:
			// i와 j를 미리 정하여 엘사의 눈사람을 완성하고 시작한다. (O(N^2))
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					int elsa = snow[i] + snow[j];
					
					// 투포인터 알고리즘을 사용하여 안나의 눈사람을 만든다. (O(N))
					int left = 0;
					int right = N-1;
					
					while(left < right) {
						// 엘사가 선택한 눈덩이는 다시 고를 수 없다.
						if(left == i || left == j) {
							left++;
							continue;
						}
						
						if(right == i || right == j) {
							right--;
							continue;
						}
						
						int anna = snow[left] + snow[right];
						
						if(elsa > anna) left++;
						else if(elsa < anna) right--;
						// 엘사와 안나의 크기 차이가 0이면 더이상 계산할 필요가 없다.
						else {
							min = 0;
							break outer;
						}
						
						// 키차이의 최소값을 갱신한다.
						min = Math.min(min, Math.abs(elsa - anna));
						
					}
				}
			}
		
		System.out.println(min);
		
	}

}
