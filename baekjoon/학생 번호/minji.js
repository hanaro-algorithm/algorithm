const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 학생의 수
let studentNumber = []; // 각 학생 번호
for (let i = 1; i <= N; i += 1) studentNumber.push(input[i]);

const numberLen = studentNumber[0].length; // 학생 번호 길이

let minLen = 1; // 학생 번호 다르게 만들 수 있는 번호 최소길이

// 각 다른 번호나올 때까지 반복문 수행
while (minLen <= numberLen) {
  let numbers = []; // 같은 번호가 있는지 확인하기 위해 배열
  for (let student = 0; student < N; student += 1) {
    const num = studentNumber[student].slice(numberLen - minLen); // 끝부터 minLen만큽 번호 추출
    if (!numbers.includes(num)) numbers.push(num); // 같은 번호가 없을 떄만 배열에 넣기
  }
  // 배열의 길이가 N개만큼 존재하지 않을 경우는 같은 번호가 존재하므로 최소길이가 될 수 없음
  // 반면, N개만큼 존재하면 셋 다 다른 번호를 가진다는 의미이므로 최소길이가 됨 => 반복문 수행 종료
  if (numbers.length === N) break;
  minLen += 1;
}

console.log(minLen);
