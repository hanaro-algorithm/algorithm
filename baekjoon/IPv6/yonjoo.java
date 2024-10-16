import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ip = br.readLine();
        String[] groups = ip.split("::");

        if (groups.length != 1) {
            String[] head = groups[0].split(":");
            String[] tail = groups[1].split(":");
            for (int i = 0; i < head.length; i++) {
                if (head[i].length() != 4) {
                    while (head.length < 4) {
                        head[i] = "0" + head[i];
                    }
                }
            }

            for (int i = 0; i < tail.length; i++) {
                while (tail.length < 4) {
                    tail[i] = "0" + tail[i];
                }
            }

            String headAns = String.join(":", head);
            String tailAns = String.join(":", tail);

            int len = 8 - head.length - tail.length;

            String ans = headAns + ":" + "0000:".repeat(len) + tailAns;
            System.out.println(ans);

        }
        else{
            String ans = "";
            if(groups[0].startsWith("::")){
                int len = 8 - groups[0].split("::")[0].split(":").length;
                ans = "0000:".repeat(len);
            }
            String[] s = groups[0].split(":");
            for(int i = 0; i < s.length; i++){
                while(s[i].length() < 4){
                    s[i] = "0" + s[i];
                }
            }
            ans = ans + String.join(":", s);
            System.out.println(ans);
        }

    }


}
