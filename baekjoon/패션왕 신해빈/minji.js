/**
 * 문제) 패션왕 신해빈
 * 해빈이가 적어도 하나는 의상을 입을 때 경우의 수 구하기
 * - 한 번 입었던 옷들의 조합 다시 입지 않음
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let tc = +input[0]; // 테스트 케이스 개수
let line = 1; // 입력 라인 번호

let answer = '';
while (tc) {
  const n = +input[line]; // 혜빈이가 가지고 있는 의상 수
  const clothes = new Map(); // 혜빈이가 가지고 있는 의상 종류별 개수
  for (let i = line + 1; i <= line + n; i++) {
    const [clothe, type] = input[i].split(' ');
    if (clothes.has(type)) clothes.set(type, clothes.get(type) + 1);
    else clothes.set(type, 2); // 종류마다 의상을 선택하지 않는 경우도 넣어주기 위해 2부터 시작
  }
  const combi = [...clothes.values(clothes)].reduce((acc, cur) => acc * cur, 1); // 의상을 선택하는 경우의 수
  answer += combi - 1 + '\n'; // 아예 아무것도 안입는 경우(한 가지) 빼주기
  line += n + 1;
  tc--;
}
console.log(answer.trimEnd());
