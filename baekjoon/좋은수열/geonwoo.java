import java.util.Scanner;

public class BOJ_G4_2661_좋은수열 {
	static int N;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		
		find(0, new StringBuilder());

	}

	private static void find(int idx, StringBuilder sb) {
		// N 자릿수를 완성하면 그 수가 가장 작은 수이므로 출력하고 바로 종료한다.
		if(idx == N) {
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		// 1~3의 수를 넣어본다.
		for (int i = 1; i <= 3; i++) {
			// 지금 자리에 숫자 i를 넣는다.
			sb.append(i);
			
			// 숫자 i를 넣었을 때, 나쁜 수열이 되면 i를 빼고 다음 숫자를 넣어본다.
			if(!check(sb.toString())) {
				sb.setLength(sb.length()-1);
				continue;
			}
			
			// 좋은 수열을 유지한다면 다음 자리의 숫자를 찾는다.
			find(idx+1, sb);
			
			// 만약 뒤에서 모든 조건에 실패하면, 돌아와서 숫자 i를 빼고 다음 숫자를 넣어본다. (백트래킹)
			sb.setLength(sb.length()-1);
			
		}
		
	}

	// 좋은 수열인지 확인하는 함수
	private static boolean check(String str) {
		// 자릿수 계산을 위한 변수. 1씩 늘려가면서 부분 수열을 찾는다.
		int len = 1;
		
		// 지금까지 완성한 수열을 기준으로 맨 뒤부터 길이를 늘려가며 비교한다.
		for (int i = str.length()-1; i >= (str.length()+1)/2; i--) {
			// 맨 뒤부터 계산하여 길이가 len인 부분수열
			String sub2 = str.substring(i);
			// sub2의 바로 앞에 있고, 길이가 len인 부분수열
			String sub1 = str.substring(i-(len++), i);
			
			// 두 부분수열이 같으면 나쁜 수열이다.
			if(sub1.equals(sub2)) return false;
		}
		
		// for문을 통과하면 좋은 수열이다.
		return true;
	}

}
