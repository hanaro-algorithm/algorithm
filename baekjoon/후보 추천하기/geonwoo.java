import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Picture implements Comparable<Picture>{
	int num;
	int idx;
	int value;
	
	public Picture(int num, int idx, int value) {
		this.num = num;
		this.idx = idx;
		this.value = value;
	}

	@Override
	public int compareTo(Picture o) {
		if(this.value == o.value) {
			return Integer.compare(this.idx, o.idx);
		} else {
			return Integer.compare(this.value, o.value);
		}
	}
	
}

public class BOJ_S1_1713_후보추천하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int [] student = new int[101];
		List<Picture> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(student[n] > 0) {
				student[n] += 1;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).num == n) {
						list.get(j).value += 1;
						break;
					}
				}
			} else {
				if(list.size() == N) {
					Collections.sort(list);
					int num = list.get(0).num;
					student[num] = 0;
					list.remove(0);
				}
				
				list.add(new Picture(n, i, 1));
				student[n] = 1;
			}
		}
		
		for (int i = 1; i <= 100; i++) {
			if(student[i] > 0) {
				System.out.print(i+" ");
			}
		}
	}

}
