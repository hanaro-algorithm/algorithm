import java.util.Scanner;

public class BOJ_G5_2023_신기한소수 {
	static int N;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		
		find(0, 0);

	}

	private static void find(int depth, int num) {
		if(depth == N) {
			System.out.println(num);
			return;
		}
		
		// 숫자 0이 들어가면 0으로 끝나는 수는 무조건 10의 배수이므로 조건을 탈락함.
		for (int i = 1; i <= 9; i++) {
			// 2번째 자리부터 2의 배수가 들어가면, 그 숫자로 끝나는 수는 무조건 2의 배수이므로 조건을 탈락함.
			if(i % 2 == 0 && depth > 1) continue;
			
			int next = num*10 + i;
			
			if(isPrime(next)) {
				find(depth+1, next);
			}
		
		}
		
	}

	private static boolean isPrime(int n) {
		if(n == 1) return false;
		
		// 합성수의 가장 작은 소인수는 √N 이하이므로, √N보다 큰 수는 확인할 필요가 없음
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}

}
