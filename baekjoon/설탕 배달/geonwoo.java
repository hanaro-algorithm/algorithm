import java.util.Scanner;

public class BOJ_S4_2839_설탕배달 {
	
	static int N;
	static int min;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		min = 100000;
		int t = 0;
		int f = 0;
		
		for (int i = 0; i <= N/5; i++) {
			if((N-i*5)%3 == 0) {
				min = Math.min(min, i+(N-i*5)/3);
			}
		}
		
		System.out.println(min==100000?-1:min);
	}

}