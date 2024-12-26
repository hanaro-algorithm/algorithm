import java.util.Scanner;

public class BOJ_S4_1057_토너먼트 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		int a = scann.nextInt();
		int b = scann.nextInt();
		
		int round = 0;
		
		while(a != b) {
			round++;
			
			a = (a+1)/2;
			b = (b+1)/2;
		}
		
		System.out.println(round);

	}

}
