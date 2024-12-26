import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();

        list = new ArrayList<>();
        value = new int[N];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = scan.nextLine();

            int cnt = 1;

            char ch = str[i].charAt(0);
            for(int j=0; j<str[i].length(); j++) {
                if(ch!=str[i].charAt(j)) {
                    cnt++;
                    ch = str[i].charAt(j);
                }
            }

            list.add(new Node(str[i].charAt(0), str[i].charAt(str[i].length()-1),cnt));
        }

        int visit[] = new int[N];
        for(int i=0; i<N; i++) {
            visit[i] = i;
        }

        permutation(0, visit);
        System.out.println(Answer);
    }

    static int[] value;
    static int Answer = Integer.MAX_VALUE;
    static ArrayList<Node> list;

    static void permutation(int idx, int[] visit) {

        if (idx == N) {
            int cnt = list.get(visit[0]).checkPoint-1;

            for(int i=0; i<N-1; i++) {
                char end = list.get(visit[i]).b;
                char start = list.get(visit[i+1]).a;
                if(end!=start) {
                    cnt+= list.get(visit[i+1]).checkPoint;
                }else {
                    cnt+=list.get(visit[i+1]).checkPoint-1;
                }
            }
            if(Answer>cnt) {
                Answer = cnt;
            }
        }

        for (int i = idx; i < N; i++) {
            swap(visit, idx, i);
            value[idx] = visit[idx];
            permutation(idx + 1, visit);
            swap(visit, idx, i);
        }
    }

    static class Node{
        char a, b;
        int checkPoint;
        public Node(char a, char b, int checkPoint) {
            super();
            this.a = a;
            this.b = b;
            this.checkPoint = checkPoint;
        }
        @Override
        public String toString() {
            return "Node [a=" + a + ", b=" + b + ", checkPoint=" + checkPoint + "]";
        }
    }

    static void swap(int[] str, int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
