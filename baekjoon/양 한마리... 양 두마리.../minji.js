const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let tc = +input[0]; // 테스트케이스 개수
let line = 1;

let answer = '';
while (tc) {
    const [H, W] = input[line++].split(' ').map(Number); // H: 높이, W: 너비

    const grid = [];
    for (let i = 0; i < H; i++) grid.push(input[line++].trimEnd().split(''));

    const visited = Array.from({ length: H }, () => new Array(W).fill(false));

    const dr = [-1, 0, 1, 0];
    const dc = [0, -1, 0, 1];

    const dfs = (r, c) => {
        for (let i = 0; i < 4; i++) {
            const [nextR, nextC] = [r + dr[i], c + dc[i]];
            // 영역 벗어나거나 이미 방문한 경우
            if (nextR < 0 || nextR >= H || nextC < 0 || nextC >= W || visited[nextR][nextC]) continue;

            // 양의 무리에 포함시키기
            if (grid[r][c] === '#') {
                visited[nextR][nextC] = true;
                dfs(nextR, nextC);
            }
        }
        return 1;
    };

    let cnt = 0;
    for (let r = 0; r < H; r++) {
        for (let c = 0; c < W; c++) {
            // 아직 방문하지 않은 양을 만난 경우, 양의 무리 확인하기
            if (grid[r][c] === '#' && !visited[r][c]) {
                visited[r][c] = true;
                cnt += dfs(r, c);
            }
        }
    }

    answer += cnt + '\n';
    tc -= 1;
}
console.log(answer.trimEnd());
