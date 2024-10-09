const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [A, B] = [
  input[0]
    .split(' ')[0]
    .split('')
    .map(Number)
    .sort((a, b) => b - a),
  input[0].split(' ')[1],
]; // A를 배열로 바꾼후 내림차순 정렬 => B보다 작으면서 가장 큰 값 구하는 것이니까 내림차순 정렬 후 맨 처음 나온 값이 정답이됨

let result = -1;

const visited = Array.from({ length: A.length }, () => false);
const backtracking = (selected) => {
  if (result !== -1) return; // 결과값 찾은 경우 더이상 탐색 X
  if (selected.length === A.length) {
    // 시작이 0이 아니고, B보다 작은 수만
    if (+selected.join('') < +B && selected[0] !== 0) {
      result = +selected.join('');
      return;
    }
  }
  for (let idx = 0; idx < A.length; idx += 1) {
    if (!visited[idx]) {
      visited[idx] = true;
      selected.push(A[idx]);
      backtracking(selected);
      selected.pop();
      visited[idx] = false;
    }
  }
};

backtracking([]);
console.log(result);
