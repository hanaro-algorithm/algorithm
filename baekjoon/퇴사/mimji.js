const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 퇴사 일까지 남은 일수
let T = [0]; // 인덱스 1부터 시작하게 하기 위해 처음에 0 집어넣음
let P = [0];
for (let i = 1; i <= N; i += 1) {
  T.push(input[i].split(' ').map(Number)[0]);
  P.push(input[i].split(' ').map(Number)[1]);
}

let dp = Array.from({ length: N + 1 }, () => 0); // 날짜 별 최대 이익

for (let day = 1; day <= N; day += 1) {
  if (T[day] + day > N + 1) continue; // 퇴사 일 이후에 일이 끝나는 경우는 패스
  dp[day] += P[day]; // day일까지의 가능한 최대이익 구하기
  for (let next = T[day] + day; next <= N; next += 1) {
    dp[next] = Math.max(dp[day], dp[next]);
  }
}

console.log(Math.max(...dp));
