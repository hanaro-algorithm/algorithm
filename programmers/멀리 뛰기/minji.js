// 그냥 number로 하면 오버플로우 발생! bigint로 해주어야함!!
// bitint는 숫자 뒤 n을 붙임
function solution(n) {
  let answer = 0;
  let dp = Array.from({ length: 2001 }, () => 0);
  dp[1] = 1n;
  dp[2] = 2n;
  for (let i = 3; i <= n; i += 1) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  answer = dp[n] % 1234567n;
  return Number(answer);
}

console.log(solution(4));
console.log(solution(3));
