const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const colors = [];
for (let i = 1; i <= M; i += 1) colors.push(+input[i]);

let [left, right] = [1, Math.max(...colors)];
while (left <= right) {
  const mid = parseInt((left + right) / 2); // 한 사람이 가져가는 구슬 수
  let getStudents = 0; // 구슬을 가져가는 학생 수
  colors.forEach(
    (color) =>
      (getStudents +=
        color % mid === 0 ? parseInt(color / mid) : parseInt(color / mid) + 1)
  );
  if (getStudents > N)
    left = mid + 1; // 총 학생 수(N)보다 구슬을 가져가는 학생이 더 많을 경우
  else right = mid - 1;
}

console.log(left);
