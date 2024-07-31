import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = br
                    .readLine()
                    .split("\\.");
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}