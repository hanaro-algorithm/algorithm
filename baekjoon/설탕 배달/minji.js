/**
 * 3킬로그램과 5킬로그램 설탕 봉지가 있을 때, 정확히 N킬로그램 설탕을 배달할 때 필요한 봉지의 최소 개수
 *
 * 그리디 알고리즘
 * 1. 5kg 설탕 봉지 개수를 구한 후, 남은 설탕을 3kg로 만들 수 있는지 확인
 * 2. 만들 수 없다면, 5kg 설탕 봉지를 1개씩 줄여나가기
 * 3. 위 과정을 반복하다가, 오직 3kg 설탕 봉지로만 했을 때 만들 수 없다면 -1 리턴
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 배달하려는 설탕의 무게

let sugar5 = Math.floor(N / 5);
while (sugar5 >= 0) {
    let sugar3 = Math.floor((N - 5 * sugar5) / 3);

    // 정확히 N킬로그램 만들 수 있는 최소 봉지 개수
    if (sugar5 * 5 + sugar3 * 3 === N) return console.log(sugar3 + sugar5);

    sugar5 -= 1; // 5킬로그램 봉지 개수 줄이기
}

console.log(-1);
