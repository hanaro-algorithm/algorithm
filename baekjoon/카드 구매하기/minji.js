/**
 * 문제) 카드 구매하기
 * N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값
 *
 * Pi = 카드 i개가 포함된 카드팩의 가격
 * 민규는 카드의 개수가 적어도 가격이 비싸면 높은 등급의 카드가 많이 들어있다고 믿음
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function solution(N, cards) {
  const cardPacks = [0]; // 1부터 시작하기 위해 0 미리 넣어주기
  cardPacks.push(...cards);

  const dp = Array.from({ length: N + 1 }, () => 0); // dp[i] = 카드 i개를 구매했을 때 최댓값
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= i; j++) {
      dp[i] = Math.max(dp[i], dp[i - j] + cardPacks[j]);
    }
  }

  return dp[N]; // 카드 N개 구매한 최댓값
}

const N = +input[0]; // 카드의 개수(1<=N<=1000)
const cards = input[1].split(' ').map(Number); // P1 ~ Pn까지 카드 팩의 가격
console.log(solution(N, cards));
