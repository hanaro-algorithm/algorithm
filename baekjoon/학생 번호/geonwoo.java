import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_S4_1235_학생번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set;
		int N = Integer.parseInt(br.readLine());
		int min = 1;
		
		String [] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		int length = arr[0].length();
		
		// 자릿수를 1개씩 늘려가며 중복이 안되는지 확인한다.
		for (int i = length-1; i >= 0; i--) {
			// set을 사용하여 중복 여부를 확인한다.
			set = new HashSet<>();
			// 모든 학생을 구별 가능한지 여부를 저장할 변수
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				String tmp = arr[j].substring(i, length);
				// 이미 set에 존재한다면 식별이 불가능하므로 자릿수를 1 늘린다.
				if(set.contains(tmp)) {
					min++;
					flag = false;
					break;
				} else {
					set.add(tmp);
				}
			}
			if(flag) break;
		}
		
		System.out.println(min);
		
	}

}
