/**
 * 문제) 요세푸스 문제 0
 * (N, K)-요세푸스 순열 구하기
 * 1번부터 N번까지 N명의 사람이 원을 이루며 앉아있고, K번째 사람 제거
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const origin = Array.from({ length: N + 1 }, () => false);

const permutations = []; // (N, K)-요세푸스 순열
let num = 1; // 현재 위치
let index = 0; // 현재 인덱스
while (permutations.length !== N) {
  index = index + 1 === N ? N : (index + 1) % N; // 다음 인덱스로 이동
  // K번째 위치이면서 제거되지 않은 원소인 경우
  // 요세푸스 순열에 넣기
  if (num === K && !origin[index]) {
    origin[index] = true;
    permutations.push(index);
    num = 1;
    continue;
  }
  if (!origin[index]) num++; // 다음 위치 이동
}

console.log(`<${permutations.join(', ')}>`);
