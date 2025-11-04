/**
 * 카드 바꾸기
 * N개의 카드를 왼쪽에서 오른쪽으로 갈수록 적혀있는 수가 일정하게 증가하거나 감소하거나 같도록 만들어야 할 떄 최소 변경 횟수
 *
 * N≤500 ⇒ 브루트포스로 풀기
 * : 카드 2개를 선택해서 그 간격만큼 카드 바꾸는 횟수 구해서 최소값 찾기
 * 1. 6(V) 3(V) 3 1 -1
 *    간격: -3
 *    6 3 0 -3 -6 ⇒ 총 3개
 * 2. 6(V) 3 3(V) 1 -1
 *    간격: -3/2 ⇒ -1.5 (X)
 * 3. 6(V) 3 3 1(V) -1
 *    간격: -5/3 ⇒ -1.66..(X)
 * 4. 6(V) 3 3 1 -1(V)
 *    간격: -7/4 ⇒ -1.xx(X)
 * 5. 6 3(V) 3(V) 1 -1
 *    간격: 0/1 = 0
 *    3 3 3 3 3 ⇒ 총 3개
 * 6. 6 3(V) 3 1(V) -1
 *    간격: -2/2 = -1
 *    4 3 2 1 0 ⇒ 총 3개
 * 7. 6 3(V) 3 1 -1(V)
 *    간격: -4/3 = -1.xx(X)
 * 8. 6 3 3(V) 1(V) -1
 *    간격: -2/1 = -2
 *    7 5 3 1 -1 ⇒ 총 2개
 * 9. 6 3 3(V) 1 -1(V)
 *    간격: -4/2 = -2
 *    7 5 3 1 -1 ⇒ 총 2개
 * 10. 6 3 3 1(V) -1(V)
 *    간격: -2/1 = -2
 *    7 5 3 1 -1 ⇒ 총 2개
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 카드 개수
const cards = [0].concat(input[1].split(' ').map(Number)); // 카드에 적힌 수

let answer = Number.MAX_SAFE_INTEGER;
for (let card1 = 1; card1 < N; card1++) {
    for (let card2 = card1 + 1; card2 <= N; card2++) {
        const gap = (cards[card2] - cards[card1]) / (card2 - card1); // 선택한 두 카드의 간격 구하기
        if (gap !== Math.floor(gap)) continue; // 정수가 아니면 패쓰

        answer = Math.min(answer, changeCardCnt(card1, gap)); // 최소 변경 횟수 갱신
    }
}

function changeCardCnt(standard, gap) {
    const change = [...cards]; // 간격만큼 카드 새로 세팅
    for (let i = standard; i > 1; i--) change[i - 1] = change[i] - gap;
    for (let i = standard; i < N; i++) change[i + 1] = change[i] + gap;

    let cnt = 0;
    for (let c = 1; c <= N; c++) if (cards[c] !== change[c]) cnt += 1; // 변경해야하는 카드 카운트

    return cnt;
}

console.log(answer);
