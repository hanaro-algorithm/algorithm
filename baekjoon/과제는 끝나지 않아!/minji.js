const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 이번 학기의 시간(분)

const tasks = []; // 미뤄둔 과제 정보 배열
let currentTasks = [0, 0]; // 현재 수행하고 있는 과제 정보
let answer = 0; // 얻을 수 있는 총점
for (let i = 1; i <= N; i += 1) {
  const [num, score, time] = input[i].split(' ').map(Number);
  if (num === 1) {
    if (currentTasks[0] === 0)
      currentTasks = [score, time - 1]; // 처음 과제 시작하는 경우
    else {
      tasks.push([currentTasks[0], currentTasks[1]]); // 새로운 과제 나온 경우 하고 있던 과제 잠시 미루기
      currentTasks = [score, time - 1]; // 새로운 과제 수행
    }
  } else if (num === 0) currentTasks[1] -= 1; // 과제가 주어지지 않은 경우 기존의 과제 계속 수행

  // 현재 수행하고 있는 과제가 끝난 경우
  if (currentTasks[1] === 0) {
    answer += currentTasks[0]; // 해당 과제 점수를 총점에 더해주기
    if (tasks.length > 0) currentTasks = tasks.pop(); // 미뤄둔 과제가 있는 경우 최근에 넣어둔 과제 먼저 수행
  }
}

console.log(answer);
