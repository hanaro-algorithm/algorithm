const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 가지고 있는 카드 개수
const cards = new Map();
for (let i = 1; i <= N; i += 1) {
  const card = BigInt(input[i]);
  cards.set(card, (cards.get(card) || 0) + 1);
}

const cardArr = [...cards.entries()];
// 내림차순 정렬
cardArr.sort((a, b) => {
  if (a[1] > b[1]) return -1;
  else if (a[1] < b[1]) return 1;
  else {
    if (a[0] < b[0]) return -1;
    if (a[0] > b[0]) return 1;
    else return 0;
  }
});

console.log(cardArr[0][0].toString());
