import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_17615_볼모으기 {
	static int N;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		int ans = Integer.MAX_VALUE;
		
		// R, B를 왼쪽으로 몰은 경우
		ans = Math.min(ans, Math.min(collectLeft('R'), collectLeft('B')));
		// R, B를 오른쪽으로 몰은 경우
		ans = Math.min(ans, Math.min(collectRight('R'), collectRight('B')));
		
		System.out.println(ans);

	}

	private static int collectLeft(char color) {
		// 모으려는 색과 반대되는 색을 한번이라도 만났는지 여부를 나타낼 변수
		boolean flag = false;
		// flag가 true가 된 상태에서 만난 color의 개수(옮겨야 하는 공의 개수)
		int cnt = 0;
		
		for (int i = N-1; i >= 0; i--) {
			char c = str.charAt(i);
			
			// 모으려는 색과 반대되는 색을 만나면 flag를 true 해준다.
			if(c != color) flag = true;
			// 모으려는 색을 만났고, flag가 true라면 cnt++
			else if(flag) cnt++;
		}
		
		return cnt;
	}

	private static int collectRight(char color) {
		boolean flag = false;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			
			if(c != color) flag = true;
			else if(flag) cnt++;
		}
		
		return cnt;
	}

}
