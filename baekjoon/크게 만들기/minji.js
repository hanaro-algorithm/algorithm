/**
 * 문제) 크게 만들기
 * 
 * N자리 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수
 * 
 * 그리디+Stack 이용
 * → 지울 횟수가 남아있는 상태에서 Stack 배열에 본인보다 크거나 같은 수를 만날 때까지 원소 pop하여 작은 수 지우기
 * 
 * ※ 가장 작은 수가 맨 뒤에 위치할 수 있기 때문에, N자리 수를 모두 탐색 후에도 지울 수 있는 횟수가 남아있으면
 *    Stack에서 N-K 길이만큼 추출하기
 */

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, K] = input[0].split(' ').map(Number);
const numbers = input[1].split('').map(Number); // N자리 숫자

const newNumbers = []; // K개의 수를 뺀 새로운 수의 배열

let removeCnt = K;
for (let i = 0; i < N; i++){
    // 지울 횟수가 남아있고, 새로운 수의 배열에서 현재 원소보다 크거나 같은 수가 나올 때까지 배열 내 수 빼기
    while (removeCnt > 0 && newNumbers.length > 0 && newNumbers.at(-1) < numbers[i]) {
        newNumbers.pop();
        removeCnt -= 1; // 작은 수 지우기
    }
    newNumbers.push(numbers[i]);
}

if (removeCnt > 0) newNumbers.splice(N-K); // 지울 수 있는 횟수가 남은 경우 뒤에 있는 수 제거
console.log(newNumbers.join(''));