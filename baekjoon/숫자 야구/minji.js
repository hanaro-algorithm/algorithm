/**
 * 문제) 숫자 야구
 * 영수가 생각하고 있을 가능성 있는 답의 총 개수 구하기
 *
 * 스트라이크: 같은 수이고, 같은 자리에 위치할 경우
 * 볼: 같은 수이지만, 다른 자리에 위치할 경우
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 질문 횟수
let questions = [];
for (let i = 1; i <= N; i++) questions.push(input[i].split(' '));

// 해당 숫자가 질문에서 얻은 답과 일치하는지 확인
const game = (num1, num2, s, b) => {
  let strike = 0;
  let ball = 0;
  for (let i = 0; i < 3; i++) {
    if (num1[i] === num2[i])
      strike += 1; // 같은 자리이면서 같은 숫자인 경우 스트라이크
    else if (num1.includes(num2[i])) ball += 1; // 같은 숫자가 존재하지만 같은 자리가 아닌 경우 볼
  }
  if (strike === s && ball === b)
    return true; // 질문에서 얻은 답과 일치하는 경우
  else return false;
};

let result = 0;
for (let n = 123; n <= 987; n++) {
  const nl = n.toString().split(''); // 문자열로 변경 후 배열로 반환
  if (nl.includes('0')) continue; // 0을 포함하고 있는 경우 제외
  if (nl[0] === nl[1] || nl[1] === nl[2] || nl[0] === nl[2]) continue; // 서로 다른 수인지 확인
  let flag = true; // 모든 조건 충족하는지 판단하는 변수
  for (let q = 0; q < N; q++) {
    const [num, s, b] = questions[q];
    // 해당 조건 충족하지 않는 경우 다음 수로 비교
    if (!game(nl, num.split(''), +s, +b)) {
      flag = false;
      break;
    }
  }
  if (flag) result += 1; // 모든 조건 충족한 경우 가능한 수 카운트 증가
}

console.log(result);
