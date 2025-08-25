/**
 * 숫자놀이
 * 홀순이와 짝순이 중 몇 번째 수에서 이겼는지 출력
 *
 * 정수 N개를 통틀어 최대 K번 사용해 상대방 수보다 1이 큰 수를 만들어야 함!
 * - 1은 무조건 존재함!
 * - 1,2,3 이런식으로 1씩 큰 수를 만들어야함
 *
 * 홀순: 1
 * 짝순: 1+1
 * 홀순: 3
 * 짝순: 1+3
 * 홀순: 1+1+3
 * 짝순: 3+3
 * 홀순: 3+3+1
 * 짝순: 3+3+1+1
 * 홀순: 3+3+3
 * 짝순: 3+3+3+1
 * 홀순: 3+3+3+1+1
 * 짝순: 3+3+3+3
 * 홀순: 3+3+3+3+1
 *
 * 그리디 이용
 * - 1부터 K개로 수를 만들 수 있는지 파악 => 큰 수를 먼저 사용(사용 횟수 최소화 가능)
 * - 남아있는 수가 사용가능한 정수의 수보다 작은 경우는 해당 정수 사용 X
 * - 사용가능한 정수를 이용해서 수를 만드는 최소의 개수 구하기
 * - 최소의 개수가 K보다 큰 경우는 게임 더 진행 X
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사용하는 정수의 수
const numbers = input[1].split(' ').map(Number).reverse(); // 사용하는 정수 내림차순정렬
const K = +input[2]; // 최대 사용 횟수

const name = ['holsoon', 'jjaksoon'];

let num = 1;
while (true) {
    let cnt = 0;
    let remain = num;
    for (const n of numbers) {
        if (remain < n) continue;
        else if (remain % n === 0) {
            cnt += parseInt(remain / n);
            break;
        } else {
            const portion = parseInt(remain / n);
            cnt += portion;
            remain -= portion * n;
        }
    }
    if (cnt > K) {
        return console.log(`${name[num % 2]} win at ${num}`);
    }
    num++;
}
