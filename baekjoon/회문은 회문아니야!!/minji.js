/**
 * 회문은 회문아니야!!
 *
 * 팰린드롬: 앞에서 읽든 뒤에서 읽든 같은 문자열
 * 팰린드롬이 아닌 가장 긴 부분문자열 길이 출력
 *
 * 문자열 이용
 * - 팰린드롬이 아닌 경우, 바로 해당 문자열 길이 출력
 * - 팰린드롬인데 모든 문자열이 2개 이상으로 이루어진 경우, 문자열 길이-1 출력
 * --- ex) AAABBAAA -> AAABBAA이 팰린드롬이 아닌 부분문자열의 가장 긴 길이
 * - 팰린드롬이면서 모든 문자열이 같은 경우, -1 출력
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const str = input[0]; // 문자열(1<=str<=50)

const isPalindrome = str === str.split('').reverse().join(''); // 팰린드롬인지 확인

const isAllSame = str.split('').every((s) => s === str[0]); // 문자열이 모두 같은지 확인

if (!isPalindrome) console.log(str.length);
else if (!isAllSame) console.log(str.length - 1);
else console.log(-1);
