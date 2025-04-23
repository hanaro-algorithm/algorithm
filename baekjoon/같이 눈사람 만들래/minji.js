/**
 * 문제) 같이 눈사람 만들래?
 * 두 눈사람의 키 차이 중 최솟값 구하기
 *
 * 엘사와 안나 각각 눈사람(두 눈덩이 필요)을 만들어야 함
 * 각 눈사람은 위 눈덩이는 아래 눈덩이보다 지름이 크지 않아야함
 * 눈사람의 키 = 두 눈덩이 지름의 합
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 눈덩이 개수 N
const diameters = input[1].split(' ').map(Number); // 각 눈덩이의 지름
diameters.sort((a, b) => a - b); // 눈덩이 오름차순 정렬

const isUsed = Array.from({ length: N }, () => false); // 엘사가 선택한 눈덩이

let result = Number.MAX_SAFE_INTEGER;
const selectAnna = (elsaSize) => {
  const remains = diameters.filter((_, index) => !isUsed[index]);
  let [start, end] = [0, remains.length - 1];
  while (start < end) {
    const annaSize = remains[start] + remains[end];
    result = Math.min(result, Math.abs(elsaSize - annaSize));
    if (elsaSize > annaSize) start += 1;
    else if (elsaSize < annaSize) end -= 1;
    else return false;
  }
  return true;
};

// 엘사가 눈덩이 두 개 선택하는 경우
for (let i = 0; i < N; i++) {
  isUsed[i] = true;
  for (let j = i + 1; j < N; j++) {
    isUsed[j] = true;
    if (!selectAnna(diameters[i] + diameters[j])) return console.log(result);
    isUsed[j] = false;
  }
  isUsed[i] = false;
}

console.log(result);
