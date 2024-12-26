import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            String[] mbti = new String[n];

            for (int i = 0; i < n; i++) {
                mbti[i] = scan.next();
            }

            // 만약 MBTI 수가 32개 이상이면, 항상 0의 거리를 갖는 세 조합을 찾을 수 있음
            if (n > 32) {
                System.out.println(0);
                continue;
            }

            int minDistance = Integer.MAX_VALUE;

            // 모든 세 조합을 순회하여 최소 거리 계산
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int distance = calculateDistance(mbti[i], mbti[j])
                                + calculateDistance(mbti[j], mbti[k])
                                + calculateDistance(mbti[k], mbti[i]);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
            }

            System.out.println(minDistance);
        }

    }

    private static int calculateDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
