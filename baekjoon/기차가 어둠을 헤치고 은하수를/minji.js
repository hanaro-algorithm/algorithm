/**
 * 문제) 기차가 어둠을 헤치고 은하수를
 * 비트 마스킹 이용 => a << b = a * 2^b
 * 1 i x => i번째 기차에 x번째 좌석에 사람 앉히기 => i번째 기차 |= 2^(x-1)
 * 2 i x => i번째 기차에 x번째 좌석에 앉은 사람 내리기 => i번째 기차 &= ~(2^(x-1))
 * 3 i => i번째 기차에 앉은 승객 모두 한칸씩 뒤로 이동(20번재 앉아있는 사람은 내리기) => i번째 기차 << 1 &= ~(2^20)
 * 4 i => i번째 기차에 앉은 승객 모두 한칸씩 앞으로 이동 => i번쨰 기차 >> 1 &= ~(2^20)
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 기차의 수, M: 명령의 수
const trains = Array.from({ length: N }, () => 0); // 모든 기차 처음엔 0으로 초기화

for (let order = 1; order <= M; order++) {
  const [o, i, x] = input[order].split(' ').map(Number);
  if (o === 1) trains[i - 1] |= 1 << (x - 1);
  else if (o === 2) trains[i - 1] &= ~(1 << (x - 1));
  else if (o === 3) {
    trains[i - 1] <<= 1;
    trains[i - 1] &= ~(1 << 20);
  } else if (o === 4) {
    trains[i - 1] >>= 1;
    trains[i - 1] &= ~(1 << 20);
  }
}

console.log(new Set(trains).size);
