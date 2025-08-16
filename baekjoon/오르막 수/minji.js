const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 수의 길이

// dp[수의 길이][시작 숫자]
const dp = Array.from({ length: 1001 }, () => new Array(10).fill(0));

for (let i = 0; i <= 9; i++) dp[1][i] = 1; // 1자리 수는 모두 1개(자기 자신)

for (let i = 2; i <= N; i++) {
    for (let j = 0; j <= 9; j++) {
        for (let k = 0; k <= 9; k++) {
            if (j <= k) {
                dp[i][j] += dp[i - 1][k] % 10007; // 이전 자리수가 본인보다 크거나 같은 수의 개수만 더하기
            }
        }
    }
}

const sum = dp[N].reduce((acc, cur) => (acc += cur), 0);
console.log(sum % 10007);
