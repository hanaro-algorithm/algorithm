/**
 * 문제) 방 번호
 * 다솜이의 방 번호가 주어졌을 때, 필요한 숫자 세트(0~9)의 개수의 최솟값 구하기
 * 이때, 6은 9로, 9는 6으로 뒤집어 사용 가능
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = input[0].split('').map(Number); // 다솜이의 방 번호 N

const number = Array.from({ length: 10 }, () => 0); // 0부터 9까지 숫자 세트 배열 만들기
N.forEach((n) => {
  if (n === 6 || n === 9)
    number[6] += 1; // 6이랑 9는 뒤집어 사용 가능하므로 모두 6 인덱스에 넣어주기
  else number[n] += 1; // 나머지 숫자들은 해당 인덱스에 추가
});

number[6] = Math.ceil(number[6] / 2); // 6 인덱스의 갯수 2로 나눈 후 올림

console.log(Math.max(...number)); // 가장 큰 수 리턴(=필요한 숫자 세트 최솟값)
