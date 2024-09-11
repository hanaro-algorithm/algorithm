import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_S3_16922_로마숫자만들기 {
	static int N;
	static Set<Integer> set;
	static int [] nums = {1, 5, 10, 50};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		// 서로 다른 수의 개수를 구하기 위해 HashSet을 사용한다.
		set = new HashSet<>();
		
		find(0, 0, 0);
		
		System.out.println(set.size());

	}

	private static void find(int idx, int cnt, int sum) {
		// N개의 자릿수를 사용해서 문자를 만들었을 때, 값을 set에 넣어본다.
		if(cnt == N) {
			set.add(sum);
			
			return;
		}
		
		// 같은 숫자를 중복적으로 사용하지 않기 위해 i를 idx부터 시작한다.
		for (int i = idx; i < 4; i++) {
			find(i, cnt+1, sum+nums[i]);
		}
		
	}

}
