const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = [];

const chicken = []; // 치킨집 위치
const home = []; // 집 위치
for (let i = 1; i <= N; i += 1) {
    map.push(input[i].split(" ").map(Number));
} // 지도

for (let i = 0; i < N; i += 1) {
    for (let j = 0; j < N; j += 1) {
        if (map[i][j] == 1) home.push([i, j]);
        if (map[i][j] == 2) chicken.push([i, j]);
    }
}

let visited = new Array(chicken.length).fill(false); // 치킨집 조합 구하기 위한 방문 여부 배열
let selected = []; // 치킨집 선택 조합
let result = Number.MAX_SAFE_INTEGER;

function dfs(depth, index) {
    // 살려둘 M개의 치킨집을 모두 고른 경우
    if (depth === M) {
        let distance = new Array(home.length).fill(Number.MAX_SAFE_INTEGER); // 치킨집과 집과의 거리

        for (let [cX, cY] of selected) {
            home.map((h, idx) => {
                let [hX, hY] = h;
                distance[idx] = Math.min(
                    Math.abs(cX - hX) + Math.abs(cY - hY),
                    distance[idx]
                );
            });
        }
        // 치킨거리가 가장 작은 수 출력
        result = Math.min(
            distance.reduce((acc, cur) => (acc += cur), 0),
            result
        );
        return result;
    }

    // 치킨 집 조합 구하기
    // 이때, 이미 만든 조합은 제외하기 위해 배열에서 자신보다 작은 인덱스의 값은 제외하고 M개 선택하도록 -> 시간 초과 해결
    for (let i = index; i < chicken.length; i += 1) {
        if (!visited[i]) {
            visited[i] = true; // 방문여부 표시
            selected.push(chicken[i]); // 조합에 해당 치킨집 위치 넣기
            dfs(depth + 1, i + 1);
            selected.pop();
            visited[i] = false;
        }
    }
}

dfs(0, 0);

console.log(result);
