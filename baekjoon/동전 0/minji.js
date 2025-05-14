/**
 * 문제) 동전 0
 * 준규가 가지고 있는 동전(N종류)을 적절히 사용해서 가치의 합을 K로 만들 때, 필요한 동전 개수의 최솟값
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let [N, K] = input[0].split(' ').map(Number); // N: 동전 종류, K: 가치의 합
const coins = []; // 동전의 가치(오름차순정렬)
for (let n = 1; n <= N; n++) {
  const coin = +input[n];
  if (coin <= K) coins.push(coin); // K보다 작은 동전들만 저장
}

let cnt = 0; // 필요한 동전 개수
// 가장 가치가 큰 동전부터 탐색
for (let c = coins.length - 1; c >= 0; c--) {
  if (K < coins[c]) continue; // 현재 K보다 동전의 크기가 큰 경우 다음 동전 확인
  cnt += parseInt(K / coins[c]); // 최대한 큰 동전을 많이 사용하기
  K %= coins[c]; // 동전 사용하고 남은 나머지 금액
}
console.log(cnt);
