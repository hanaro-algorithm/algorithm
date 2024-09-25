import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] num = new String[N];
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = num[0].length() - 1; i >= 0; i--) {
            for (int j = 0; j < num.length; j++) {
                list.add(num[j].substring(i));
                set.add(num[j].substring(i));
            }
            if (list.size() == set.size()) {
                System.out.println(num[0].length()-i);
                break;
            }
            list.clear();
            set.clear();
        }
    }
}