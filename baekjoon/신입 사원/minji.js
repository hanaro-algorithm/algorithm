const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let t = +input[0]; // 테스트 케이스 개수
let line = 1;

let answer = '';
while (t--) {
  const N = +input[line++]; // 지원자 수
  const scores = [];
  for (let n = 0; n < N; n++) scores.push(input[line++].split(' ').map(Number));
  scores.sort((a, b) => a[0] - b[0]); // 서류심사 성적 순위 기준으로 오름차순 정렬

  let cnt = 0; // 합격자 수
  let minRank = Number.MAX_SAFE_INTEGER;
  for (const [score1, score2] of scores) {
    // 면접 등수가 더 높은 사람만 합격
    if (score2 < minRank) {
      minRank = score2;
      cnt++;
    }
  }
  answer += cnt + '\n';
}
console.log(answer.trimEnd());
