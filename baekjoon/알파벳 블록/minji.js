/**
 * 알파벳 블록
 * : 버튼을 순서대로 눌렀을 떄 완성된 문자열 출력하기
 *
 * [버튼 동작]
 * 1. 문자열 맨 뒤에 블록 추가
 * 2. 문자열 맨 앞에 블록 추가
 * 3. 최근에 추가된 블록 제거
 *
 * 덱 자료구조 이용
 * - 인덱스 2개를 두고 앞에 넣고, 뒤에 넣기
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 버튼을 누른 횟수

let headIdx = 0;
let tailIdx = 0;

const strObj = {};
let lastIdx = [];
for (let i = 1; i <= N; i++) {
    const [button, c] = input[i].split(' ');

    // 버튼 1번 동작
    if (button === '1') {
        strObj[tailIdx] = c;
        lastIdx.push(tailIdx);
        tailIdx++;
    }
    // 버튼 2번 동작
    else if (button === '2') {
        strObj[--headIdx] = c;
        lastIdx.push(headIdx);
    }
    // 버튼 3번 동작
    else if (button === '3') {
        if (lastIdx.length === 0) continue; // 빈 문자열인 경우 수행 X
        delete strObj[lastIdx.pop()]; // 가장 최근에 추가한 데이터 삭제
    }
}

const strArr = [...Object.entries(strObj)];
if (strArr.length === 0) console.log(0); // 빈 문자열인 경우 0 출력
else {
    console.log(
        strArr
            .sort((a, b) => a[0] - b[0])
            .map((str) => str[1])
            .join('')
    );
}
