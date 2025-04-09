/**
 * 문제) 블로그
 * X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구하기
 *
 * 슬라이딩 윈도우
 * X 크기 내에 합이 최대인지 확인하여 최대 방문자 수 업데이트
 * 같은 경우, 기간 1씩 증가
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, X] = input[0].split(' ').map(Number);
const visitors = input[1].split(' ').map(Number); // N일동안 방문자 수

let [start, end] = [0, X];
let currentSum = 0; // 현재 윈도우 크기 범위 내의 방문자수 합
for (let i = start; i < end; i++) currentSum += visitors[i];
let maxSum = currentSum; // 최대 방문자 수
let date = 1; // 최대 방문자 수를 가진 기간의 횟수

while (end < N) {
  currentSum -= visitors[start]; // 앞 기간 방문자 수 제외
  currentSum += visitors[end]; // 새로운 기간 방문자 수 더하기

  // 현재 최대 방문자 수보다 더 클 경우 최대 방문자 수와 기간 갱신
  if (maxSum < currentSum) {
    maxSum = currentSum;
    date = 1;
  } else if (maxSum === currentSum) date += 1; // 같을 경우 기간 더하기

  // 윈도우 범위 이동
  start++;
  end++;
}

if (maxSum === 0) return console.log('SAD');

console.log(`${maxSum}\n${date}`);
