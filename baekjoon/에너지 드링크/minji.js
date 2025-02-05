const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 남이있는 에너지 드링크 개수
const energyDrinks = input[1].split(' ').map(Number); // 에너지 드링크 남은 양
energyDrinks.sort((a, b) => a - b); // 에너지 드링크 양 기준으로 오름차순 정렬

for (let i = 0; i < N - 1; i += 1) energyDrinks[N - 1] += energyDrinks[i] / 2; // 마지막 에너지 드링크에 0번째부터 N-1까지 에너지 드링크 절반씩 붓기

console.log(energyDrinks[N - 1]); // 최종적으로 합친 에너지 드링크 양 출력
