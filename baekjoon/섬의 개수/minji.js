/**
 * 섬의 개수 구하기 => 걸어서 갈 수 있으면 하나의 섬임(가로, 세로, 대각선으로 이동 가능)
 * - 1: 땅, 0: 바다
 *
 * DFS 문제 => 땅인 경우 연결되어있는 땅을 표시해 섬의 개수 구하기
 * 1. 방문 배열 만들기(이미 섬으로 카운트된 땅은 DFS 수행 X)
 * 2. 아직 섬으로 표시되지 않은 땅은 DFS 수행 후 섬의 개수로 카운트
 * 3. DFS 수행 시 연결되어있는 땅을 섬으로 표시하는 작업 수행
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;
const dr = [-1, 0, 1, 0, -1, -1, 1, 1];
const dc = [0, -1, 0, 1, -1, 1, -1, 1];

let answer = '';
while (true) {
    const [w, h] = input[line].split(' ').map(Number); // 너비 w, 높이 h
    if (w === 0 || h === 0) break; // 마지막 입력 줄

    const mapInfo = [];
    for (let i = 0; i < h; i++) mapInfo.push(input[line + 1 + i].split(' ').map(Number));

    const visited = Array.from({ length: h }, () => new Array(w).fill(false));

    const dfs = (r, c) => {
        for (let i = 0; i < 8; i++) {
            const [nr, nc] = [r + dr[i], c + dc[i]];
            // 영역 벗어나거나 이미 섬으로 카운트 된 땅인 경우는 패쓰
            if (nr < 0 || nc < 0 || nr >= h || nc >= w || visited[nr][nc]) continue;

            if (mapInfo[nr][nc] === 1) {
                visited[nr][nc] = true; // 섬으로 연결
                dfs(nr, nc);
            }
        }
        return 1;
    };

    let cnt = 0; // 섬 개수
    for (let r = 0; r < h; r++) {
        for (let c = 0; c < w; c++) {
            // 섬으로 카운트 되지 않은 땅인 경우 => DFS 수행
            if (!visited[r][c] && mapInfo[r][c] === 1) {
                visited[r][c] = true;
                cnt += dfs(r, c);
            }
        }
    }

    answer += cnt + '\n';
    line += h + 1;
}

console.log(answer.trimEnd());
