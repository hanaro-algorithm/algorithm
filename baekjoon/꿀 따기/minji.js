/**
 * 문제) 꿀 따기
 * 1xN으로 구성된 장소에서 서로 다른 두 곳에 벌을 각각 배치한 후, 또 다른 한 장소를 벌통을 둠
 * 벌이 벌통으로 향할 때, 벌들이 딸 수 있는 가능한 최대의 꿀 양 계산
 * [조건]
 * - 두 마리가 모두 지나간 장소에서 두 마리 모두 표시된 양 만큼 꿀 딸 수 있음(벌통 장소도 꿀 딸 수 있음)
 * - 벌이 시작한 장소에서는 어떤 벌도 꿀 딸 수 X
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 장소의 수 N
const honey = input[1].split(' ').map(Number); // 각 장소에서 꿀을 딸 수 있는 양

const sum = Array.from({ length: N }, () => 0); // 누적합
sum[0] = honey[0];
for (let h = 1; h < N; h++) sum[h] = sum[h - 1] + honey[h];

let answer = 0;
// 1. 벌통 위치가 가장 왼쪽에 있을 때
// - 벌 한 마리는 가장 오른쪽에 위치
// - 다른 한 마리는 벌통과 지정된 벌 사이의 최대 꿀을 딸 수 있는 위치 계산
for (let i = 1; i < N - 1; i++)
  answer = Math.max(answer, sum[N - 2] + sum[i - 1] - honey[i]);

// 2) 벌통 위치가 가장 오른쪽에 있을 때
// - 벌 한마리는 가장 왼쪽에 위치
// - 1)과 동일
for (let i = 1; i < N - 1; i++)
  answer = Math.max(
    answer,
    sum[N - 1] - honey[0] - honey[i] + sum[N - 1] - sum[i]
  );

// 3) 벌통 위치가 중간에 있을 때
// - 두 벌이 양 끝에 존재
for (let i = 1; i < N - 1; i++)
  answer = Math.max(answer, sum[N - 2] - honey[0] + honey[i]);

console.log(answer);
