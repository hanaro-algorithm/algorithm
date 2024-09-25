const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [L, C] = input[0].split(' ').map(Number);
let mo = []; // 모음
let ja = []; // 자음

input[1].split(' ').forEach((item) => {
  // 모음 분리
  if (['a', 'e', 'i', 'o', 'u'].includes(item)) mo.push(item);
  else ja.push(item); // 자음 분리
});

// 조합 함수
const getCombination = (arr, num) => {
  const results = []; // 조합 결과
  if (num === 1) return arr.map((a) => [a]);

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombination(rest, num - 1);
    const attached = combinations.map((el) => [fixed, ...el]);
    results.push(...attached);
  });
  return results;
};

const secretKeys = new Set(); // 중복 제거를 위해 집합 이용
let moCombi = getCombination(mo, 1); // 모음 1개 선택
let jaCombi = getCombination(ja, 2); // 자음 2개 선택

moCombi.map((mc) => {
  jaCombi.map((jc) => {
    let rest = []; // 선택된 모음 1개랑 자음 2개 제외한 나머지 값들
    rest.push(...mo.filter((m) => !mc.includes(m)));
    rest.push(...ja.filter((a) => !jc.includes(a)));
    let restCombi = getCombination(rest, L - 3); // 모음 1개, 자음 2개 선택 후 나머지 중 선택

    // 자음 2개 모음 1개로 L개 다 만들어졌을 때는 나머지 값 조합 X
    if (restCombi.length === 0) secretKeys.add([...mc, ...jc].sort().join(''));

    restCombi.map((rc) => {
      // 모음, 자음, 나머지 정렬 후 문자열로 만들기
      secretKeys.add([...mc, ...jc, ...rc].sort().join(''));
    });
  });
});

// 출력도 문자 순으로
[...secretKeys].sort().forEach((item) => console.log(item));
