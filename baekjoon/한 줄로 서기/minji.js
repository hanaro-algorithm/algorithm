const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const n = +input[0]; // 사람의 수
const arr = input[1].split(" ").map(Number);

let position = Array.from({ length: n }, () => 0); // 사람들이 서있는 줄

let answer = ""; // 출력할 정답

arr.map((person, id) => {
  let cnt = 0; // 왼쪽에 서있는 사람들 중 나보다 키큰 사람 수
  let index = 0; // 현재 위치
  while (true) {
    // 왼쪽에 서있는 사람들 중 나보다 키큰 사람의 개수가 동일하고, 현재 위치에 아무도 없을 경우 중단
    if (position[index] === 0 && cnt === person) {
      break;
    }
    // 나보다 키큰 사람 배치하기 위해 현재 인덱스가 0인지 확인
    if (position[index] === 0) {
      cnt += 1;
    }
    index += 1;
  }
  position[index] = id + 1; // 현재 인덱스에 사람 배치
});

position.map((p) => (answer += p + " "));

console.log(answer);
