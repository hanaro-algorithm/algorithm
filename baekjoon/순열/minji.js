const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;
let answer = '';
while (true) {
  if (!input[line]) break; // 모든 테스트 케이스가 끝난 경우 반복문 종료
  const [data, num] = [
    input[line].split(' ')[0].split(''), // 주어진 값 배열로 변경
    +input[line].split(' ')[1], // 타겟 위치
  ];
  let count = 0; // 몇개의 순열 값이 나왔는지 카운트 => 메모리 초과 해결 방법
  let result = ''; // 해당 타겟 위치에 있는 순열 값

  const backtracking = (arr, visited, selected) => {
    if (result) return; // 원하는 순열 값 찾은 경우 더이상 탐색 X
    // 순열 값이 나왔을 때
    if (selected.length === arr.join('').length) {
      count += 1;
      // 타겟 위치의 순열 값 구한 경우
      if (count === num) {
        result = selected.join('');
        return;
      }
    }
    for (let index = 0; index < arr.length; index += 1) {
      if (!visited[index]) {
        visited[index] = true; // 방문 표시
        selected.push(arr[index]); // 현재 값 넣기
        backtracking(arr, visited, selected);
        selected.pop(); // 현재 값 빼기
        visited[index] = false; // 방문 해제
      }
    }
  };

  const visited = Array.from({ length: data.length }, () => false);
  backtracking(data, visited, []);
  if (!result)
    answer += `${data.join('')} ${num} = No permutation\n`; // 찾지 못한 경우
  else answer += `${data.join('')} ${num} = ${result}\n`;

  line += 1;
}

answer = answer.trimEnd();
console.log(answer);
