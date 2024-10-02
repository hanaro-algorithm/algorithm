const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [S, E, Q] = input[0].split(' ');
const startMinute = +S.split(':')[0] * 60 + +S.split(':')[1]; // 입장 분으로 형식 변경
const endMinute = +E.split(':')[0] * 60 + +E.split(':')[1]; // 종료 분으로 형식 변경
const quitMinute = +Q.split(':')[0] * 60 + +Q.split(':')[1]; // 스트리밍 종료 분으로 형식 변경

let entry = new Set(); // 제시간에 입장한 사람
let exit = new Set(); // 제시간에 나간 사람

let line = 1;
while (true) {
  if (!input[line]) break; // 채팅이 더 이상 존재안할 경우 반복문 종료
  const [time, name] = input[line].split(' '); // [채팅 입력 시간, 사람 이름]
  const timeMinute = +time.split(':')[0] * 60 + +time.split(':')[1];
  if (timeMinute <= startMinute) entry.add(name); // 개강총회 시간 전에 채팅 남긴 사람 입장 집합테이블에 넣기
  if (timeMinute >= endMinute && timeMinute <= quitMinute) exit.add(name); // 개강총회 종료 시간과 스트리밍 종료 시간 사이에 채팅 남긴 사람 퇴장 집합 테이블에 넣기

  line += 1;
}

let count = 0;
// 둘 다 존재할 경우만 카운트
exit.forEach((person) => {
  if (entry.has(person)) count += 1;
});

console.log(count);
