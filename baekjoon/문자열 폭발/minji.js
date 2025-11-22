/**
 * 폭발 문자열을 다 제거하고 남은 문자열 출력
 *
 * 스택 이용
 * - 폭발 문자열의 마지막 문자와 동일한 문자가 나올 때까지 모두 stack에 넣기
 * - 마지막 문자와 동일한 문자를 만난 경우, 현재 stack에 있는 문자 하나씩 꺼내면서 폭발 문자열을 만들 수 있는지 확인
 * - 폭발 문자열을 만들 수 있으면, 그대로 stack에서 폭발 문자열 제거
 * - 만들 수 없으면, 다시 꺼낸 문자열 stack에 집어넣고 마지막 문자도 stack에 넣기(폭발 문자열이랑 다른 문자열임)
 * 문자: aabca, 폭발문자열: abc
 *
 * stack = []
 * 1. a -> stack = [a]
 * 2. a -> stack = [a, a]
 * 3. b -> stack = [a, a, b]
 * 4. c -> 현재 스택에 있는 문자 하나씩 꺼내면서 폭발 문자열을 만들 수 있는지 확인
 * 4-1. pop = [b, a], stack = [a]
 * 5. a -> stack = [a, a]
 *
 * aa 출력
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const str = input[0].trim().split(''); // 1<=str<=1,000,000
const boomStr = input[1].trim().split(''); // 1<=boomStr<=36

// 폭발 문자열이 기존 문자열보다 긴 경우,
// 기존 문자열 그대로 출력(폭발시킬 수 있는 문자열 X)
if (str.length < boomStr.length) return console.log(str.join(''));

let stack = []; // 문자열 담을 스택

for (const s of str) {
    // 폭발 문자열의 마지막 문자와 같지 않을 경우 스택에 넣기
    if (s !== boomStr.at(-1)) {
        stack.push(s);
    } else {
        // 폭발 문자열의 마지막 문자와 동일한 문자가 발견된 경우,
        // 폭발 문자열과 동일한 문자인지 확인
        const currentPop = []; // stack에서 폭발 문자열과 일치하는 문자 담기
        for (let i = 0; i < boomStr.length - 1; i++) {
            const popStr = stack.pop(); // stack에서 문자 꺼내기
            currentPop.push(popStr); // 현재 뽑아낸 문자 넣기
            // 폭발 문자열과 일치하지 않을 경우
            if (popStr !== boomStr[boomStr.length - 2 - i]) {
                stack.push(...currentPop.reverse()); // 꺼냈던 문자들 다시 넣기
                stack.push(s); // 현재 문자도 stack에 넣기
                break; // 더 이상 탐색 X
            }
        }
    }
}
if (stack.length === 0) console.log('FRULA'); // 스택에 남아있는 문자가 없는 경우 다 폭발 -> FRULA
else console.log(stack.join(''));
