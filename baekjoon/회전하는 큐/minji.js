/**
 * 문제) 회전하는 큐
 * 해당 원소를 뽑아낼 때 드는 2번, 3번 연산의 최솟값 출력
 *
 * [연산]
 * 1. 첫 번째 원소 뽑기(맨 앞에 있는 원소 없어짐)
 * 2. 왼쪽으로 한 칸 이동(맨 앞에 있는 원소가 맨 뒤로 이동)
 * 3. 오른쪽으로 한 칸 이동(맨 뒤에 있는 원소가 맨 앞으로 이동)
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 큐의 크기, M: 뽑아내려고 하는 수의 개수
const numbers = input[1].split(' ').map(Number); // 뽑아내려고 하는 수의 위치

const queue = [];
for (let i = 1; i <= N; i++) queue.push(i); // 큐 초기화

let index = 0; // 뽑아내려고 하는 수 인덱스
let cnt = 0;
while (index < numbers.length) {
  // 뽑아내려고 하는 수 찾은 경우 뽑기(1번 연산)
  if (queue[0] === numbers[index]) {
    queue.shift();
    index++; // 뽑아내려는 다음 수
    continue;
  }
  const numberIndex = queue.findIndex((q) => q === numbers[index]); // 뽑아내려는 숫자의 위치 찾기
  if (numberIndex <= queue.length - numberIndex - 1)
    queue.push(queue.shift()); // 왼쪽에 있는 원소 <= 오른쪽에 있는 원소: 2번 연산 수행
  else queue.unshift(queue.pop()); // 왼쪽에 있는 원소 > 오른쪽에 있는 원소: 3번 연산 수행
  cnt++; // 2번/3번 연산 수행한 횟수 증가
}
console.log(cnt);
