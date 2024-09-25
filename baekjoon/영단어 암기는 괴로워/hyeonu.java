import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.length() < M)
                continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                if(!map.get(o1).equals(map.get(o2)))
                    return map.get(o2).compareTo(map.get(o1));
                if(o1.length() != o2.length())
                    return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        };

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(comp);

        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}