const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M, H] = input[0].split(' ').map(Number);
const ladder = Array.from({ length: H }, () => new Array(N).fill(0)); // 사다리 정보

for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(' ').map(Number);
    ladder[a - 1][b - 1] = 1;
    ladder[a - 1][b] = -1;
}
const check = () => {
    for (let i = 0; i < N; i++) {
        let current = i;
        for (let j = 0; j < H; j++) {
            if (ladder[j][current] === 1) current++;
            else if (ladder[j][current] === -1) current--;
        }
        if (current !== i) return false;
    }
    return true;
};

let answer = Infinity;
const backtracking = (depth, startH) => {
    if (check()) {
        answer = Math.min(answer, depth);
        return;
    }

    if (depth === 3) return;

    for (let r = startH; r < H; r++) {
        for (let c = 0; c < N - 1; c++) {
            if (ladder[r][c] || ladder[r][c + 1]) continue;
            ladder[r][c] = 1;
            ladder[r][c + 1] = -1;
            backtracking(depth + 1, r);
            ladder[r][c + 1] = 0;
            ladder[r][c] = 0;
        }
    }
};

backtracking(0, 0);

console.log(answer === Infinity ? -1 : answer);
