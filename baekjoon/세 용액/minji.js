/**
 * 문제) 세 용액
 * 서로 다른 세 용액을 혼합할 때 특성값이 0에 가장 가까운 용액을 만드는 세 용액 출력
 *
 * => 투포인터
 * 한 용액과 다른 두 개의 용액으로 특성값 0에 가깝게 만들 수 있는지 탐색
 * 다른 두 개의 용액 -> 투포인터 적용
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 전체 용액의 수
const solution = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b); // N개의 용액들의 특성값(오름차순 정렬)

let resultSum = Number.MAX_SAFE_INTEGER;
let result = [];

for (let s = 0; s < N; s++) {
  let start = s + 1;
  let end = N - 1;
  while (start < end) {
    const sum = solution[s] + solution[start] + solution[end];
    if (Math.abs(sum) < Math.abs(resultSum)) {
      resultSum = sum;
      result = [solution[s], solution[start], solution[end]];
    }

    if (sum === 0) break;
    else if (sum > 0) end--;
    else start++;
  }
}
console.log(result.join(' '));
