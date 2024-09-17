const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// N: 회전 초밥 벨트에 놓인 접시, d: 초밥 가짓수, k: 연속해서 먹는 접시의 수, c: 쿠폰 번호
const [N, d, k, c] = input[0].split(' ').map(Number);
let sushi = []; // 벨트위에 놓인 초밥 종류
for (let i = 1; i <= N; i += 1) sushi.push(Number(input[i]));

let start = 0; // 시작점
let end = k; // 끝점

let arr = [c]; // 쿠폰 번호 해당 접시 미리 리스트에 넣어놓기
for (let i = start; i < end; i += 1) arr.push(sushi[i]); // 초기값

let max = Number.MIN_SAFE_INTEGER;

while (start < N) {
  max = Math.max(max, new Set(arr).size); // 최대 종류 구하기

  arr.splice(1, 1); // 맨 앞 접시 제거
  arr.push(sushi[end]); // 새로운 접시 추가
  start += 1;
  if (end === N - 1)
    end = 0; // end가 N이 되었을 때 다시 인덱스 0부터 시작
  else end += 1;
}
console.log(max);
