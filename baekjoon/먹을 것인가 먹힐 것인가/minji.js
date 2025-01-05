const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트 케이스 개수
let line = 1;

while (T > 0) {
  const [N, M] = input[line].split(' ').map(Number);
  const A = input[line + 1].split(' ').map(Number);
  const B = input[line + 2]
    .split(' ')
    .map(Number)
    .sort((a, b) => a - b); // B 그룹 오름차순 정렬

  let answer = 0;

  // 이분 탐색
  A.forEach((a) => {
    let [left, right] = [0, M];
    while (left < right) {
      const mid = parseInt((left + right) / 2);
      if (a > B[mid]) left = mid + 1;
      else right = mid;
    }
    answer += left;
  });

  console.log(answer);
  line += 3;
  T -= 1;
}
