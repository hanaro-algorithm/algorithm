import java.util.Scanner;

public class BOJ_S4_2960_에라토스테네스의체 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		int K = scann.nextInt();
		int cnt = 0;
		
		// 소수의 배수인 수들을 true 해줄 배열
		boolean [] prime = new boolean[N+1];
		
		// 2부터 N까지 숫자들을 지운다.
		for (int i = 2; i <= N; i++) {
			// 앞에 있던 소수들의 배수인 경우 넘어간다.
			if(prime[i]) continue;
			
			// 이번에 지울 숫자가 K번째면 출력하고 종료한다. (소수 지우기)
			if(++cnt == K) {
				System.out.println(i);
				System.exit(0);
			}
			
			for (int j = i*i; j <= N; j+= i) {
				// 앞에 있던 소수들의 배수인 경우 넘어간다.
				if(prime[j]) continue;
				
				// 이번에 지울 숫자가 K번째면 출력하고 종료한다. (소수의 배수 지우기)
				if(++cnt == K) {
					System.out.println(j);
					System.exit(0);
				}
				
				// 소수의 배수임을 처리해준다.
				prime[j] = true;
			}
			
		}

	}

}
