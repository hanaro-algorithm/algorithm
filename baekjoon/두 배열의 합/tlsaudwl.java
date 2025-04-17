import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] B = new int[m];
        for(int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        // A의 부분합
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        // B의 부분합
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumB);

        long result = 0;

        for (int a : sumA) {
            int target = T - a;
            int lower = lowerBound(sumB, target);
            int upper = upperBound(sumB, target);
            result += (upper - lower);
        }

        System.out.println(result);
    }

    // target 이상 처음 나오는 위치
    public static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // target 초과 처음 나오는 위치
    public static int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
