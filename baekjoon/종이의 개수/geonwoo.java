import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1780_종이의개수 {
	static int minus, zero, plus;
	static int [][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 종이의 칸 숫자를 저장할 2차원 배열
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0, 0부터 가로X세로로 N까지 확인해보는 함수
		check(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		
	}

	private static void check(int sr, int sc, int size) {
		// 시작 칸에 적힌 숫자를 확인한다.
		int n = paper[sr][sc];
		// 범위 안의 칸이 모두 같은 숫자인지 확인할 변수
		boolean flag = true;
		
		// sr, sc부터 size 크기만큼 모든 칸이 n과 같은 숫자인지 확인한다.
		outer:
			for (int i = sr; i < sr+size; i++) {
				for (int j = sc; j < sc+size; j++) {
					// 하나라도 다르다면 break 하고, flag를 false 처리한다.
					if(paper[i][j] != n) {
						flag = false;
						break outer;
					}
				}
			}
		
		// 모두 같은 숫자라면 해당 숫자의 카운트를 +1 해준다.
		if(flag) {
			add(n);
		// 아니라면 종이를 더 작은 단위로 쪼갠다.
		} else {
			for (int i = sr; i < sr+size; i += size/3) {
				for (int j = sc; j < sc+size; j += size/3) {
					check(i, j, size/3);
				}
			}
		}
		
	}

	// 숫자 n의 카운트를 +1 해주는 함수
	private static void add(int n) {
		
		if(n == -1) minus++;
		else if(n == 0) zero++;
		else if(n == 1) plus++;
	}

}
