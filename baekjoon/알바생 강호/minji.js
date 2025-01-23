const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 총 손님의 수
const tips = []; // 각 손님들이 지불할 팁
for (let i = 1; i <= N; i += 1) tips.push(+input[i]);
tips.sort((a, b) => b - a); // 팁 내림차순 정렬

let total = 0; // 강호가 받을 총 팁 가격
tips.forEach((tip, idx) => {
  const getTip = tip - idx;
  total += getTip > 0 ? getTip : 0; // 지불할 팁이 음수인 경우 팁 못받음
});

console.log(total);
