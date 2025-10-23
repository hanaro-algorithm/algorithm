/**
 * 우리집엔 도서관이 있어
 * 
 * 책 번호 순서대로 정렬할 때, 움직여야 하는 책의 횟수 구하기
 * -> 책 움직이는 방법: 한 권의 책 빼서 맨 위에 올리기
 * 
 * 맨 아래부터 탐색하면서 현재 꽂혀야하는 책의 번호보다 작은 수 찾기 = 옮겨야하는 책의 개수
 * - 동일하다면 다음으로 꽂혀야하는 책 번호 탐색
 */

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0]; // 책의 개수
const books = [];
for (let b = 1; b <= N; b++) books.push(+input[b]); // 현재 꽂혀있는 책 순서

let answer = 0;
let currentNum = N; // 맨 아래에 위치해야하는 책 번호(가장 큰 번호)
for (let b = N - 1; b >= 0; b--) {
    if (books[b] === currentNum) {
        currentNum -= 1;
        continue;
    } else if (books[b] < currentNum) answer++;
}

console.log(answer);