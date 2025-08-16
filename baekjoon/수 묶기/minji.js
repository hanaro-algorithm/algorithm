const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 수열의 크기
let answer = 0;

const negative = [];
const positive = [];
// 양수(1은 바로 더하기)와 음수 나누기(0은 음수 쪽으로 넣기)
for (let i = 1; i <= N; i++) {
    const num = +input[i];
    if (num <= 0) negative.push(num);
    else if (num === 1) answer += 1;
    else positive.push(num);
}

// 음수는 오름차순 정렬, 양수는 내림차순 정렬(가장 큰 수끼리 곱하기 위해서)
negative.sort((a, b) => a - b);
positive.sort((a, b) => b - a);

// 음수 묶기
for (let i = 0; i < negative.length; i += 2) {
    if (i < negative.length - 1) answer += negative[i] * negative[i + 1];
    else answer += negative[i];
}

// 양수 묶기
for (let i = 0; i < positive.length; i += 2) {
    if (i < positive.length - 1) answer += positive[i] * positive[i + 1];
    else answer += positive[i];
}

console.log(answer);
