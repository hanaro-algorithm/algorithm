import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> enter = new HashSet<>();
        Set<String> exit = new HashSet<>();
        int cnt = 0;

        String input;
        while((input = br.readLine()) != null){
            String t = input.split(" ")[0];
            String n = input.split(" ")[1];

            if(comp(t,S) <= 0)
                enter.add(n);

            if(comp(t,E) >= 0 && comp(t,Q) <= 0){
                if(enter.contains(n))
                    exit.add(n);
            }
        }
        System.out.println(exit.size());
    }

    static int comp(String t1, String t2) {
        int h1 = Integer.parseInt(t1.split(":")[0]);
        int m1 = Integer.parseInt(t1.split(":")[1]);
        int h2 = Integer.parseInt(t2.split(":")[0]);
        int m2 = Integer.parseInt(t2.split(":")[1]);

        if(h1 != h2)
            return Integer.compare(h1, h2);
        else{
            return Integer.compare(m1, m2);
        }
    }
}