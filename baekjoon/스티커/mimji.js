const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트 케이스 개수
let line = 1;

let answer = ''; // 정답 출력 문자열
while (T > 0) {
  let n = +input[line]; // 스티커 열 길이
  let stickers = []; // 스티커 담을 배열
  stickers.push(input[line + 1].split(' ').map(Number)); // 0행 담기
  stickers.push(input[line + 2].split(' ').map(Number)); // 1행 담기
  // 스티커가 1x1인 경우
  if (n === 1) {
    answer += Math.max(stickers[0][0], stickers[1][0]) + '\n';
  } else {
    let dp = Array.from({ length: 2 }, () => new Array(n).fill(0)); // 스티커 누적합 배열
    dp[0][0] = stickers[0][0]; // 초기화
    dp[1][0] = stickers[1][0];
    dp[0][1] = stickers[1][0] + stickers[0][1];
    dp[1][1] = stickers[0][0] + stickers[1][1];

    for (let i = 2; i < n; i += 1) {
      // 스티커 누적값 넣기
      dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
      dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
    }
    answer += Math.max(dp[0][n - 1], dp[1][n - 1]) + '\n';
  }

  T -= 1;
  line += 3;
}

answer = answer.trimEnd();
console.log(answer);
