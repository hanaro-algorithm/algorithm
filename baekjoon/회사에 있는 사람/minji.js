/**
 * 문제) 회사에 있는 사람
 * => 현재 회사에 있는 모든 사람 구하기
 * enter: 출근, leave: 퇴근
 * 해시 셋 이용 => enter이면 set에 넣고, leave이면 set에서 빼기
 * 해시 셋에 존재하는 사람들 출력
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 출입 기록의 수
const company = new Set(); // 출입카드 시스템

for (let i = 1; i <= n; i++) {
  const [name, log] = input[i].split(' ');
  if (log === 'enter') company.add(name);
  else company.delete(name);
}

let answer = [...company].sort().reverse();
console.log(answer.join('\n'));
