import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String group = br.readLine();
            int members = Integer.parseInt(br.readLine());

            List<String> memberList = new ArrayList<>();
            for(int j = 0; j < members; j++){
                memberList.add(br.readLine());
            }

            map.put(group, memberList);
        }
        for(int i = 0; i < M; i++){
            String n = br.readLine();
            String input = br.readLine();
            if(input.equals("0")){
                List<String> membs = map.get(n);
                membs.sort(((o1, o2) -> o1.compareTo(o2)));
                for(String m : membs){
                    sb.append(m + "\n");
                }
            }
            else{
                for(Map.Entry<String, List<String>> m : map.entrySet()){
                    if(m.getValue().contains(n)){
                        sb.append(m.getKey() + "\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}
