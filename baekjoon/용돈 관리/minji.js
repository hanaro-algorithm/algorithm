const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const moneyList = [];
for (let i = 1; i <= N; i += 1) moneyList.push(+input[i]);
let [minMoney, maxMoney] = [
  Math.max(...moneyList),
  moneyList.reduce((acc, cur) => acc + cur, 0),
];

// 돈을 얼마나 인출하는지 확인하는 함수
const checkWithDraw = (k) => {
  let withdrawCnt = 0;
  let currentMoney = 0;
  for (let day = 0; day < N; day += 1) {
    if (currentMoney < moneyList[day]) {
      withdrawCnt++;
      currentMoney = k;
    }
    currentMoney -= moneyList[day];
  }
  return withdrawCnt;
};

let answer = minMoney;
while (minMoney <= maxMoney) {
  const midMoney = parseInt((minMoney + maxMoney) / 2);
  const withdrawCnt = checkWithDraw(midMoney);
  if (withdrawCnt > M) minMoney = midMoney + 1;
  else {
    maxMoney = midMoney - 1;
    answer = midMoney;
  }
}

console.log(answer);
