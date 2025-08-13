import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                plus.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                minus.add(num);
            }
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int sum = 0;

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 < plus.size()) {
                sum += plus.get(i) * plus.get(i + 1);
            } else {
                sum += plus.get(i);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size()) {
                sum += minus.get(i) * minus.get(i + 1);
            } else {
                if (zeroCount == 0) {
                    sum += minus.get(i);
                }
            }
        }

        sum += oneCount;

        System.out.println(sum);
    }
}
