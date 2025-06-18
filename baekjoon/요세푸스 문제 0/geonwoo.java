import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S4_11866_요세푸스문제0 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		int M = scann.nextInt();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		
		while(!q.isEmpty()) {
			for (int i = 0; i < M-1; i++) {
				q.add(q.poll());
			}
			
			int n = q.poll();
			sb.append(n).append(", ");
			
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());

	}

}
