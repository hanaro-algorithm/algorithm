import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] coords = new int[n];
        int[] sortedCoords;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coords[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 및 중복 제거
        sortedCoords = coords.clone();
        Arrays.sort(sortedCoords);
        Map<Integer, Integer> compressedMap = new HashMap<>();

        int rank = 0;
        for (int value : sortedCoords) {
            if (!compressedMap.containsKey(value)) {
                compressedMap.put(value, rank++);
            }
        }

        for (int value : coords) {
            sb.append(compressedMap.get(value)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
