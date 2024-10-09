import java.util.Scanner;

public class BOJ_S1_3107_IPv6 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		String input = scann.nextLine();
		
		// 맨 처음이나 맨 마지막이 콜론 2개로 끝나는 경우 0을 추가해준다.
		if(input.charAt(0) == ':') {
			input = '0' + input;
		}
		
		if(input.charAt(input.length()-1) == ':') {
			input = input + '0';
		}
		
		String [] addr = input.split(":");
		int len = addr.length;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			String str = addr[i];
			// str이 비어있으면(해당 위치에 콜론 2개가 등장했다면) 필요한 개수만큼 0000:을 붙여준다.
			if(str.equals("")) {
				for (int j = 0; j < 8 - (len-1); j++) {
					sb.append("0000:");
				}
				continue;
			}
			
			// 그 외의 경우에는 필요한 개수만큼 앞에 0을 붙여준다.
			if(str.length() < 4) {
				for (int j = 0; j < 4 - str.length(); j++) {
					sb.append('0');
				}
			}
			
			sb.append(str+":");
		}
		
		// 마지막 :는 필요없으므로 제거한다.
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
