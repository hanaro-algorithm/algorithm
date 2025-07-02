import java.util.*;

public class Main {
    static int N, K;
    static List<String> words = new ArrayList<>();
    static boolean[] learned = new boolean[26];
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            word = word.substring(4, word.length() - 4);
            words.add(word);
        }

        learned['a' - 'a'] = true;
        learned['c' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int index, int count) {
        if (count == K - 5) {
            int readable = 0;
            for (String word : words) {
                boolean canRead = true;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (!learned[ch - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readable++;
            }
            max = Math.max(max, readable);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }
}
