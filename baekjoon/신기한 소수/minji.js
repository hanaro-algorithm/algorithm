const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // N자리 숫자
const prime = [2, 3, 5, 7]; // 일의 자리인 소수

const checkPrime = (num) => {
    if (num < 2) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
};

let answer = '';
const dfs = (numbers, len) => {
    if (len === N) {
        answer += Number(numbers) + '\n';
        return;
    }
    for (let odd = 1; odd <= 9; odd += 2) {
        const num = numbers + String(odd);
        if (checkPrime(+num)) {
            dfs(num, len + 1);
        }
    }
};

prime.forEach((p) => dfs(p, 1));
console.log(answer.trimEnd());
