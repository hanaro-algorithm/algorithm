const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [X, Y] = input[0].split(' ').map(Number); // 게임 횟수: X, 이긴 게임: Y
const Z = Math.floor((Y * 100) / X); // 승률 => 소수점 버림

// z가 99%인 경우에는 분모가 0이 되므로 -1 반환
if (Z >= 99) {
  console.log(-1);
} else {
  const a = Math.ceil((100 * Y - (Z + 1) * X) / (Z - 99));
  console.log(a);
}

/* 풀이 참고
 * Z = (Y*100)/X
 * 이떄, Z가 값이 바뀌는 게임 횟수를 구하는 것이니까, a가 게임 횟수라고 가정하면,
 * a 값을 구하는 것이므로, a를 좌항에 두고 나머지는 우항에 두어 계산
 * Z+1 = ((Y+a)*100)/(X+a)
 * (Z+1)(X+a) = (Y+a)*100
 * XZ+aZ+X+a = 100Y+100a
 * aZ+a-100a = 100Y-XZ-X
 * (Z-99)a = 100Y-(Z+1)X
 * a = (100Y-(Z+1)X)/(Z-99)
 */
