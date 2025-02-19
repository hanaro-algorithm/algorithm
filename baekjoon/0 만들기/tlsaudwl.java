import java.util.*;

public class Main {
    static int N;
    static ArrayList<String> results; // 정답 저장할 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            results = new ArrayList<>();
            findExpressions(1, "1"); // 시작 숫자는 "1"
            Collections.sort(results); // 사전순 정렬
            for (String expr : results) {
                System.out.println(expr);
            }
            System.out.println();
        }
    }

    // 백트래킹을 이용한 모든 경우 탐색
    public static void findExpressions(int num, String expr) {
        if (num == N) { // N까지 왔으면
            if (calculate(expr) == 0) { // 계산 결과가 0이면
                results.add(expr); // 정답 리스트에 추가
            }
            return;
        }

        int nextNum = num + 1;
        findExpressions(nextNum, expr + " " + nextNum); // 숫자 연결
        findExpressions(nextNum, expr + "+" + nextNum); // 덧셈
        findExpressions(nextNum, expr + "-" + nextNum); // 뺄셈
    }

    // 문자열 수식을 계산하는 함수
    public static int calculate(String expr) {
        expr = expr.replace(" ", "");
        int sum = 0, num = 0;
        char sign = '+'; // 첫 숫자는 무조건 양수

        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // 숫자 처리
            } else {
                sum = (sign == '+') ? sum + num : sum - num; // 이전 연산 적용
                num = 0;
                sign = c; // 연산자 업데이트
            }
        }
        sum = (sign == '+') ? sum + num : sum - num; // 마지막 숫자 처리
        return sum;
    }
}
