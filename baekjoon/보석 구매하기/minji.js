const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 보석이 나열되어있는 줄 개수

let resultValue = 0;
const buyArea = [];
for (let i = 1; i <= 2 * n; i += 2) {
    const L = +input[i]; // 보석의 개수
    const jewels = input[i + 1].split(' ').map(Number); // 보석 가치

    let maxValue = 0;
    let buyStart = 0;
    let buyEnd = 0;
    for (let start = 0; start < L; start++) {
        let acc = 0;
        for (let end = start; end < L; end++) {
            acc += jewels[end];
            // 더 큰 보석 가치를 얻을 수 있을 때
            if (acc > maxValue) {
                maxValue = Math.max(maxValue, acc);
                buyStart = start;
                buyEnd = end;
            }
            // 가치가 동일할 때 보석 개수가 더 작은거 선택
            else if (acc === maxValue) {
                if (buyEnd - buyStart > end - start) {
                    buyStart = start;
                    buyEnd = end;
                }
            }
        }
    }

    resultValue += maxValue;
    buyArea.push([buyStart + 1, buyEnd + 1]);
}

console.log(resultValue);
buyArea.forEach((buy) => console.log(buy.join(' ')));
