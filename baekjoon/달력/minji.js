const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 일정의 개수
let maxDate = Number.MIN_SAFE_INTEGER; // 마지막 일정이 있는 날짜
let dates = [];
for (let i = 1; i <= N; i += 1) {
  const [S, E] = input[i].split(' ').map(Number);
  dates.push([S, E]);
  maxDate = Math.max(maxDate, E);
}

const culmulativeDate = Array.from({ length: maxDate + 1 }, () => 0); // 일정별 합 계산
dates.forEach((date) => {
  for (let day = date[0]; day <= date[1]; day += 1) culmulativeDate[day] += 1;
});

let answer = 0;
let width = 0; // 연속된 일정별 가로
let height = 0; // 연속된 일정별 세로
for (let i = 1; i < culmulativeDate.length; i += 1) {
  if (culmulativeDate[i] === 0) {
    answer += width * height; // 연속된 일정이 하나 나왔으므로 가로*세로를 정답에 더하기
    // 가로, 세로 다시 0으로 초기화
    width = 0;
    height = 0;
    continue;
  }
  width += 1; // 가로 늘리기
  height = Math.max(height, culmulativeDate[i]); // 세로는 연속된 일정들의 합 중 최댓값으로
}

answer += width * height;
console.log(answer);
