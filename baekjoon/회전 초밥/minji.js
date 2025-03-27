/**
 * 문제) 회전 초밥
 * 손님이 먹을 수 있는 초밥의 최대 가짓수
 * 풀이 => 슬라이딩 윈도우 이용(start가 마지막까지 간 경우 종료)
 * 윈도우 크기 범위 내에 쿠폰 초밥 추가한 후 중복 값 제거하여 가짓수 최댓값 갱신
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, d, k, c] = input[0].split(' ').map(Number);
const plate = [];
for (let i = 1; i <= N; i++) plate.push(+input[i]); // 벨트 위 초밥

let [start, end] = [0, k]; // 슬라이딩 윈도우 범위
const choice = new Map();
choice.set(c, 1); // 쿠폰 초밥 추가
for (let i = start; i < end; i++)
  choice.set(plate[i], (choice.get(plate[i]) || 0) + 1);

let answer = choice.size;
while (start < N) {
  choice.set(plate[start], choice.get(plate[start]) - 1); // 앞에 초밥 종류 하나 감소
  if (choice.get(plate[start]) === 0) choice.delete(plate[start]); // 초밥 종류가 0이면 제거
  choice.set(plate[end], (choice.get(plate[end]) || 0) + 1); // 새로운 초밥 종류 추가

  // 슬라이딩 윈도우 범위 이동
  start += 1;
  end = (end + 1) % N;

  answer = Math.max(choice.size, answer);
}

console.log(answer);
