const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, M] = input[0].split(" ").map(Number); // N: 세로크기, M: 가로크기
let map = [];
let copy_map = [];
let result = 0;

// 0은 빈칸, 1은 벽, 2는 바이러스
for (let i = 1; i <= N; i += 1) {
    map[i - 1] = input[i].split(" ").map(Number);
    copy_map.push(Array.from({ length: M }, () => 0));
}

let dx = [-1, 0, 1, 0];
let dy = [0, -1, 0, 1];

function dfs(depth) {
    // 벽 3개 세운 경우
    if (depth === 3) {
        for (let i = 0; i < N; i += 1) {
            for (let j = 0; j < M; j += 1) {
                copy_map[i][j] = map[i][j]; // 지도 복사(원본 유지)
            }
        }
        for (let i = 0; i < N; i += 1) {
            for (let j = 0; j < M; j += 1) {
                if (copy_map[i][j] === 2) virus(i, j); // 벽을 세운 지도에서 바이러스 퍼뜨리기
            }
        }
        result = Math.max(result, safeArea());
        return;
    }

    // 벽 3개 세우는 조합
    for (let i = 0; i < N; i += 1) {
        for (let j = 0; j < M; j += 1) {
            if (map[i][j] === 0) {
                map[i][j] = 1; // 벽 세우기
                dfs(depth + 1);
                map[i][j] = 0;
            }
        }
    }
}

// 바이러스 퍼뜨리기
function virus(x, y) {
    for (let i = 0; i < 4; i += 1) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (copy_map[nx][ny] === 0) {
            copy_map[nx][ny] = 2;
            virus(nx, ny);
        }
    }
}

// 벽 3개 세운 후, 바이러스로부터 안전한 영역 카운트
function safeArea() {
    let count = 0;
    for (let i = 0; i < N; i += 1) {
        for (let j = 0; j < M; j += 1) {
            if (copy_map[i][j] === 0) count += 1;
        }
    }
    return count;
}

dfs(0);

console.log(result);
