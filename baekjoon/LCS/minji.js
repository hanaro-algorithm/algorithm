/**
 * 문제) LCS
 * 
 * 최장 공통 부분 수열(LCS) 길이 구하기
 * DP 이용 → DP[i][j]: A의 i번째까지 문자열과 B의 j번째까지 문자열의 공통 부분 수열의 길이
 * 
 * A의 i번째와 B의 j번째 문자가 같으면: DP[i][j] = DP[i-1][j-1]+1
 * A의 i번째와 B의 j번째 문자가 같지 않으면: DP[i][j] = MAX(DP[i-1][j], DP[i][j-1])
 */

const fs = require('fs');
const input = fs.readFileSync('./text.txt').toString().split('\n');

const A = input[0].split('');
const B = input[1].split('');

const A_Len = A.length+1;
const B_Len = B.length+1;

// DP 배열 생성(0번째는 모두 0으로 초기화: 공통 부분 수열이 존재하지 않음)
const dp = Array.from({ length: A_Len }, () => new Array(B_Len).fill(0));

for (let i = 1; i < A_Len; i++){
    for (let j = 1; j < B_Len; j++){
        if (A[i-1] === B[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
}

console.log(dp[A_Len-1][B_Len-1]);