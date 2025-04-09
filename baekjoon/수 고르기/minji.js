/**
 * 문제) 수 고르기
 * N개의 정수로 이루어진 수열 A[1], A[2], ..., A[N]이 있을 때
 * 이 수열에서 두 수 고른경우(같은 수일 수 있음), 그 차이가 M이상이면서 제일 작은 차 구하기
 * 풀이) 투 포인터 이용
 * 1. 수열 오름차순 정렬
 * 2. start는 0인덱스 부터 end는 1 인덱스부터 시작
 * 3. 차가 M보다 작으면 end+1, M보다 크면 start+1, M이면 바로 해당 값 리턴
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // 두 정수 N과 M
const numbers = [];
for (let i = 1; i <= N; i++) numbers.push(+input[i]); // 수열 담기
numbers.sort((a, b) => a - b); // 1. 오름차순 정렬

let [start, end] = [0, 1]; // 2. start와 end 초깃값 설정
let min = Number.MAX_SAFE_INTEGER;
while (end < N) {
  const sub = numbers[end] - numbers[start]; // 두 수열의 차
  if (sub >= M) min = Math.min(min, sub); // 두 수열의 차가 M보다 크거나 같은 경우 min값 갱신

  if (sub === M) break;
  else if (sub > M)
    start += 1; // M보다 큰 경우
  else end += 1; // M보다 작은 경우
}

console.log(min);
