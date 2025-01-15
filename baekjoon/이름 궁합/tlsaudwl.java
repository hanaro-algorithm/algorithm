import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] lineCount = {
                3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
        };

        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        // A B 합하기
        StringBuilder combineAB = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            combineAB.append(A.charAt(i));
            combineAB.append(B.charAt(i));
        }

        // A B 획수를 배열로
        int[] countArray = new int[combineAB.length()];
        for (int i = 0; i < combineAB.length(); i++) {
            countArray[i] = lineCount[combineAB.charAt(i) - 'A'];
        }

        // 궁합 계산
        while (countArray.length > 2) {
            int[] newArray = new int[countArray.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = (countArray[i] + countArray[i + 1]) % 10;
            }
            countArray = newArray;
        }

        System.out.printf("%d%d\n", countArray[0], countArray[1]);
    }
}
