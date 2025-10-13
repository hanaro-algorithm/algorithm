const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 두 전봇대 사이의 전깃줄 개수

// 전기줄 정보 저장
const electricWire = [];
for (let w = 1; w <= N; w++) {
    const [A, B] = input[w].split(' ').map(Number);
    electricWire.push({ A, B });
}
electricWire.sort((a, b) => a.A - b.A); // A 전봇대 기준 오름차순

const dp = Array.from({ length: N }, () => 1); // dp 배열 생성(본인 포함하기 위해 1로 초기화)

for (let i = 1; i < N; i++) {
    for (let j = 0; j < i; j++) {
        // 합선이 생기지 않는 경우, 전깃줄 최대값 갱신
        if (electricWire[j].B < electricWire[i].B) dp[i] = Math.max(dp[i], dp[j] + 1);
    }
}

console.log(N - Math.max(...dp)); // 총 전깃줄 - 합선이 생기지 않는 가장 긴 전깃줄 = 최소 제거 횟수
