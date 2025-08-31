import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        List<String> ops = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("1")) {
                ops.add("1" + input[1]);
            } else if (input[0].equals("2")) {
                ops.add("2" + input[1]);
            } else {
                if (!ops.isEmpty()) ops.remove(ops.size() - 1);
            }
        }

        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();

        for (String op : ops) {
            char type = op.charAt(0);
            char ch = op.charAt(1);
            if (type == '1') back.append(ch);
            else front.append(ch);
        }

        StringBuilder result = new StringBuilder();
        result.append(front.reverse()).append(back);

        if (result.length() == 0) System.out.println(0);
        else System.out.println(result.toString());
    }
}
