import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_14891_톱니바퀴 {
	static List<List<Integer>> list = new ArrayList<>();
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				int n = str.charAt(j) - '0';
				list.get(i).add(n);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			arr = new int[4];
			
			if(idx == 0) {
				arr[0] = direction;
				checkRight(0, 1);
				if(arr[1] != 0) {
					checkRight(1, 2);
				}
				if(arr[2] != 0) {
					checkRight(2, 3);
				}
			} else if(idx == 1) {
				arr[1] = direction;
				checkLeft(1, 0);
				checkRight(1, 2);
				if(arr[2] != 0) {
					checkRight(2, 3);
				}
			} else if(idx == 2) {
				arr[2] = direction;
				checkRight(2, 3);
				checkLeft(2, 1);
				if(arr[1] != 0) {
					checkLeft(1, 0);
				}
			} else if(idx == 3) {
				arr[3] = direction;
				checkLeft(3, 2);
				if(arr[2] != 0) {
					checkLeft(2, 1);
				}
				if(arr[1] != 0) {
					checkLeft(1, 0);
				}
			}
			
			for (int j = 0; j < 4; j++) {
				if(arr[j] != 0) {
					turn(j, arr[j]);
				}
			}
			
		}
		
		int ans = 0;
		
		for (int i = 0; i < 4; i++) {
			ans += list.get(i).get(0) * Math.pow(2, i);
		}
		
		System.out.println(ans);
		
	}

	private static void checkLeft(int a, int b) {
		if(list.get(a).get(6) != list.get(b).get(2)) {
			arr[b] = -arr[a];
		} 
	}

	private static void checkRight(int a, int b) {
		if(list.get(a).get(2) != list.get(b).get(6)) {
			arr[b] = -arr[a];
		} 
	}

	private static void turn(int i, int direction) {
		if(direction == 1) {
			int n = list.get(i).remove(7);
			list.get(i).add(0, n);
		} else if(direction == -1) {
			int n = list.get(i).remove(0);
			list.get(i).add(n);
		}
		
	}

}