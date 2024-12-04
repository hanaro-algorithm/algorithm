import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S5_5635_생일 {
	static class Person implements Comparable<Person> {
		String name;
		int year;
		int month;
		int day;
		
		public Person(String name, int year, int month, int day) {
			super();
			this.name = name;
			this.year = year;
			this.month = month;
			this.day = day;
		}

		@Override
		public int compareTo(Person o) {
			if(this.year != o.year) {
				return Integer.compare(this.year, o.year);
			} else if(this.month != o.month) {
				return Integer.compare(this.month, o.month);
			} else {
				return Integer.compare(this.day, o.day);	
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Person [] arr = new Person[N];
		
		for (int i = 0; i < N; i++) {
			String [] input = br.readLine().split(" ");
			
			String name = input[0];
			int day = Integer.parseInt(input[1]);
			int month = Integer.parseInt(input[2]);
			int year = Integer.parseInt(input[3]);
			
			arr[i] = new Person(name, year, month, day);
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N-1].name);
		System.out.println(arr[0].name);
		
	}

}
