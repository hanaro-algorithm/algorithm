/**
 * 입국심사
 * 상근이와 친구들이 심사를 받는데 걸리는 최소 시간 구하기
 *
 * 인원: M명, 심사대: N개, 각 심사대에서 걸리는 시간: Tk
 * => 이분탐색 이용(최종 최소시간을 정해놓고 풀기)
 * - 최소시간 내에 심사받을 수 있는 사람 >= M: 최소시간 줄이기
 * - 최소시간 내에 심사받을 수 있는 사람 < M: 최소시간 늘리기
 *
 * ex) 6명, T=[7, 10]
 * - 범위: 1~42
 * 1. 최소시간=21 -> 7심사대: 21/7=3명 + 10심사대: 21/10=2명 => 총 5명 가능 => 최소시간 늘리기(22~42)
 * 2. 최소시간=32 -> 7심사대: 32/7=4명 + 10심사대: 32/10=3명 => 총 7명 가능 => 최소시간 줄이기(22~31)
 * 3. 최소시간=26 -> 7심사대: 26/7=3명 + 10심사대: 26/10=2명 => 총 5명 가능 => 최소시간 늘리기(27~31)
 * 4. 최소시간=29 -> 7심사대: 29/7=4명 + 10심사대: 29/10=2명 => 총 6명 가능 => 최소시간 줄이기(27~28)
 * 5. 최소시간=27 -> 7심사대: 27/7=3명 + 10심사대: 27/10=2명 => 총 5명 가능 => 최소시간 늘리기(28~28)
 * 6. 최소시간=28 -> 7심사대: 28/7=4명 + 10심사대: 28/10=2명 => 총 6명 가능 => 최종선택
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 심사대, M: 인원
const T = input.slice(1, input.length - 1).map(Number);

let start = 1n; // 최소시간
let end = BigInt(Math.min(...T) * M); // 최대시간

let answer = end;
while (start <= end) {
    const mid = BigInt((start + end) / 2n); // 시간 선택

    let person = 0n; // 시간 내에 심사받을 수 있는 사람 수(Number 자료형의 범위 넘어감)
    for (const t of T) person += mid / BigInt(t);

    if (person >= M) {
        end = mid - 1n; // 심사받을 수 있는 인원이 더 많은 경우 시간 줄이기
        answer = mid;
    } else start = mid + 1n; // 심사받을 수 있는 인원이 더 적은 경우 시간 늘리기
}

console.log(answer.toString());
