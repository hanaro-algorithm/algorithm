const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 고리 회원의 수, M: 치킨 종류의 수
let chickenLike = []; // 각 회원의 치킨 선호도
for (let i = 1; i <= N; i += 1)
  chickenLike.push(input[i].split(' ').map(Number));

// 조합 구하기
function combination(arr, c) {
  const results = [];
  if (c === 1) return arr.map((a) => [a]);
  arr.forEach((fixed, index, origin) => {
    const newArr = origin.slice(index + 1);
    const newCombinations = combination(newArr, c - 1);
    const attached = newCombinations.map((c) => [fixed, ...c]);
    results.push(...attached);
  });
  return results;
}

let chickenMenu = [];
for (let i = 0; i < M; i += 1) chickenMenu.push(i); // 0~M-1 치킨 종류
const combi = combination(chickenMenu, 3); // 3개 치킨 조합구하기

let answer = 0;
combi.map((com) => {
  let likeSum = 0; // 해당 조합에 대한 치킨 선호도
  chickenLike.map((person) => {
    likeSum += Math.max(person[com[0]], person[com[1]], person[com[2]]);
  }); // 각 회원별 3종류 치킨 중 높은 치킨 선호도
  answer = Math.max(answer, likeSum); // 가장 높은 치킨 선호도
});
console.log(answer);
