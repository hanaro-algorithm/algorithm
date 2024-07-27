import java.io.*;
import java.util.*;

public class Main {

    public void solution(String[] files){
        Map<String, Integer> map = new HashMap<>();

        for(String s : files){
            String ftype = s.substring(s.indexOf('.')+1);
            map.put(ftype, map.getOrDefault(ftype, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        keySet.stream().forEach(o-> System.out.println(o + " " + map.get(o)));

    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        for(int i = 0; i < n; i++){ files[i] = br.readLine();}


        T.solution(files);


    }
}
