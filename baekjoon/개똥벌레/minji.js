const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, H] = input[0].split(' ').map(Number); // 동굴 길이 N, 높이 H
const bottomUp = Array.from({ length: H + 1 }, () => 0); // 석순 높이 누적합
const topDown = Array.from({ length: H + 1 }, () => 0); // 종유석 높이 누적합

for (let i = 1; i <= N; i++) {
    if (i % 2 === 0) topDown[+input[i]] += 1;
    else bottomUp[+input[i]] += 1;
}

for (let i = 1; i <= H; i++) {
    topDown[i] += topDown[i - 1];
    bottomUp[i] += bottomUp[i - 1];
}

const result = Array.from({ length: H + 1 }, () => 0);
let minCnt = Number.MAX_SAFE_INTEGER;

for (let h = 1; h <= H; h++) {
    result[h] += bottomUp[H] - bottomUp[h - 1];
    result[h] += topDown[H] - topDown[H - h];

    minCnt = Math.min(minCnt, result[h]);
}

let cnt = 0;
for (let h = 1; h <= H; h++) {
    if (result[h] === minCnt) cnt += 1;
}

console.log(minCnt, cnt);
