const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사람의 수
const info = [];
for (let i = 1; i <= N; i++) {
    const [weight, height] = input[i].split(' ').map(Number);
    info.push({ w: weight, h: height });
}

let result = [];
for (let i = 0; i < N; i++) {
    let rank = 1;
    for (let j = 0; j < N; j++) {
        if (i === j) continue; // 본인이면 다음 사람 확인

        // 본인보다 덩치가 큰(=키가 크고 몸무게가 큰) 사람 카운트
        if (info[i].w < info[j].w && info[i].h < info[j].h) rank++;
    }
    result.push(rank); // 순위 저장
}

console.log(result.join(' '));
