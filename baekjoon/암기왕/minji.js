const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트케이스 개수
let line = 1;

// // 이분 탐색 함수
// const binarySearch = (start, end, target, arr) => {
//   while (start <= end) {
//     const mid = parseInt((start + end) / 2);
//     if (target === arr[mid])
//       return 1; // 해당 값 찾은 경우 1 리턴
//     else if (target < arr[mid])
//       end = mid - 1; // target이 현재 값보다 작은 경우 end값 변경
//     else start = mid + 1; // target이 현재 값보다 큰 경우 start값 변경
//   }
//   return 0;
// };

let answer = '';
// 이분 탐색 풀이
// while (T > 0) {
//   const N = +input[line];
//   const note1 = input[line + 1].split(' ').map(Number); // 수첩 1에 적힌 정수들
//   note1.sort((a, b) => a - b); // 수첩1에 적힌 정수들 오름차순 정렬
//   const note2 = input[line + 3].split(' ').map(Number); // 수첩 2에 적힌 정수들
//   note2.forEach((note) => (answer += binarySearch(0, N, note, note1) + '\n'));
//   T -= 1;
//   line += 4;
// }

while (T > 0) {
  const N = +input[line];
  const note1 = new Set(input[line + 1].split(' ').map(Number));
  const note2 = input[line + 3].split(' ').map(Number);
  note2.forEach((note) => {
    if (note1.has(note)) answer += 1 + '\n';
    else answer += 0 + '\n';
  });
  T -= 1;
  line += 4;
}

answer = answer.trimEnd();
console.log(answer);
