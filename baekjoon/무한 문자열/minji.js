const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const s = input[0];
const t = input[1];

const length = s.length * t.length; // s와 t 문자열 길이 곱하기

const f_s = s.repeat(parseInt(length / s.length)); // 곱한 길이만큼 문자열 만들기
const f_t = t.repeat(parseInt(length / t.length));

if (f_s === f_t) console.log(1);
else console.log(0);
