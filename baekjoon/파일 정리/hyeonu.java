import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, ".");
            st.nextToken(); //이름 무시
            String ext = st.nextToken(); //확장자만 따옴
            int cnt = map.getOrDefault(ext, 0); //해당 확장자 개수 가져옴. 없으면 0
            map.put(ext, cnt+1); //개수 1 추가
        }

        //정렬용
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String ext : list) {
            //확장자와 개수 출력(키 값)
            System.out.println(ext + " " + map.get(ext));
        }

    }
}