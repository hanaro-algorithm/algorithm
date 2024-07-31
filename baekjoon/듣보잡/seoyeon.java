
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        HashSet<String> first;
        List<String> result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        first = new HashSet<>();
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            first.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String second = br.readLine();
            if(first.contains(second)){
                result.add(second);
            }

        }
        System.out.println(result.size());
        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}