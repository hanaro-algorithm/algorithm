/**
 * 단조 스택 이용 => 스택을 오름차순 혹은 내림차순으로 정렬해주는 알고리즘
 * 나보다 먼저 나온 인덱스는 비교할 수 없기 때문에 뒷 부분만 스택에 넣으며 비교!
 * 현재 값이 스택 최상위보다 작으면 push, 크면 pop 해주는 원리
 * 옥상 크기: [10, 3, 7, 4, 12, 2]
 * [10, 3] => 3은 10보다 작으니까 push => 최상위 3 건물을 벤치망킹 할 수 있는 건물은 총 1개
 * [10, 7] => 7은 3보다 크니까 3을 pop하고, 7을 push => 최상위 3 건물을 벤치망킹 할 수 있는 건물은 총 1개
 * [10, 7, 4] => 4는 7보다 작으니까 push => 최상위 4 건물을 벤치마킹 할 수 있는 건물은 총 2개
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 빌딩의 개수
let buildingHeight = [];
for (let i = 1; i <= N; i += 1) buildingHeight.push(+input[i]);
let answer = 0;

let stack = [];
for (let i = 0; i < N; i += 1) {
  while (stack.length > 0 && stack[stack.length - 1] < buildingHeight[i])
    stack.pop();
  stack.push(buildingHeight[i]);
  answer += stack.length - 1;
}

console.log(answer);

// 시간초과
// buildingHeight.reverse();

// let count = 0;

// while (buildingHeight.length !== 1) {
//   let index = buildingHeight.length - 1;
//   const targetBuilding = buildingHeight[index]; // 현재 빌딩
//   for (let i = index - 1; i >= 0; i -= 1) {
//     if (buildingHeight[i] < targetBuilding) count += 1;
//     else break;
//   }
//   buildingHeight.pop(); // 현재 빌딩 제외
// }

// console.log(count);
