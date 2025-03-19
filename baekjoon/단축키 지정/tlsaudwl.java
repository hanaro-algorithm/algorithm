import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        boolean[] usedKeys = new boolean[26];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            boolean assigned = false;

            // 1. 각 단어의 첫 글자로 단축키 지정 시도
            for (int j = 0; j < words.length; j++) {
                char firstChar = Character.toLowerCase(words[j].charAt(0));
                int idx = firstChar - 'a'; // a~z → 0~25 변환

                if (idx >= 0 && idx < 26 && !usedKeys[idx]) { // 사용되지 않은 경우
                    usedKeys[idx] = true;
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    assigned = true;
                    break;
                }
            }

            // 2. 첫 글자로 지정 못하면, 전체 문자열에서 단축키 찾기
            if (!assigned) {
                outerLoop:
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = Character.toLowerCase(words[j].charAt(k));
                        int idx = c - 'a';

                        if (idx >= 0 && idx < 26 && !usedKeys[idx]) {
                            usedKeys[idx] = true;
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            break outerLoop;
                        }
                    }
                }
            }

            // 3. 변환된 단어들을 출력
            System.out.println(String.join(" ", words));
        }
    }
}
