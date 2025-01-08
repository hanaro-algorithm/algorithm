import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] serialNumbers = new String[n];
        for (int i = 0; i < n; i++) {
            serialNumbers[i] = sc.nextLine();
        }

        Arrays.sort(serialNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 1. 길이가 짧은 것이 먼저
                if (a.length() != b.length()) {
                    return Integer.compare(a.length(), b.length());
                }

                // 2. 숫자의 합이 작은 것이 먼저
                int sumA = getSumOfDigits(a);
                int sumB = getSumOfDigits(b);
                if (sumA != sumB) {
                    return Integer.compare(sumA, sumB);
                }

                // 3. 사전순으로 비교
                return a.compareTo(b);
            }

            // 숫자의 합을 구하는 함수
            private int getSumOfDigits(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) { // 숫자인 경우에만 더하기
                        sum += c - '0'; // 문자를 숫자로 변환
                    }
                }
                return sum;
            }
        });

        for (String serial : serialNumbers) {
            System.out.println(serial);
        }

    }
}
