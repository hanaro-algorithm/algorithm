const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// N: 자르는 횟수가 담긴 목록의 길이, M: 자를 수 있는 지점의 개수, L: 롤케이크 길이
const [N, M, L] = input[0].split(' ').map(Number);
const S = []; // 자를 수 있는 지점
for (let i = 1; i <= M; i += 1) S.push(+input[i]);
S.push(L); // 마지막으로 롤케이크 끝 길이 담기
const Q = []; // 자르는 횟수
for (let i = 1 + M; i < 1 + M + N; i += 1) Q.push(+input[i]);

// 최소 길이 설정했을 때, Ni횟수만큼 케이크를 자를 수 있는지 확인하는 함수
const isPossibleCut = (minLen, count) => {
  let prevCm = 0; // 직전에 케이크 자른 위치
  S.forEach((s) => {
    // 최소 길이보다 케이크를 크거나 같게 자를 수 있는 경우, 자르기
    if (s - prevCm >= minLen) {
      count -= 1;
      prevCm = s;
    }
  });
  return count < 0; // 케이크 자를 수 있는지 리턴
};

let result = '';
Q.forEach((q) => {
  let maxLen = 0; // 가장 작은 조각의 길이 최대값
  let [left, right] = [1, L];
  while (left <= right) {
    const mid = parseInt((left + right) / 2); // mid: 작은 조각의 길이
    // 자를 수 있다면, 최대값 갱신해주고 작은 조각의 길이 늘리기
    if (isPossibleCut(mid, q)) {
      maxLen = Math.max(mid, maxLen);
      left = mid + 1;
    } else right = mid - 1; // 자를 수 없다면, 작은 조각 길이가 크므로 조각 길이 줄이기
  }
  result += maxLen + '\n';
});

result = result.trimEnd();
console.log(result);
