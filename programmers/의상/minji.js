// 1. 각 종류별로 0가지 선택과 1가지 선택 조합 더하기
// 2. 각 계산한 조합 곱하기
// 3. 아무것도 선택 안한 경우 빼주기(-1)
function solution(clothes) {
  let answer = 1;
  let clothType = new Map();
  clothes.map((cloth) => {
    if (clothType.has(cloth[1]))
      clothType.set(cloth[1], [...clothType.get(cloth[1]), cloth[0]]);
    else clothType.set(cloth[1], [cloth[0]]);
  });
  clothType.forEach((cloth) => {
    let combi = 0; // 각 종류별 조합 구하기
    combi += 1 + cloth.length; // 0가지 선택 + 1가지 선택
    answer *= combi;
  });
  return answer - 1; // 하나도 선택 안한 경우 빼주기
}

console.log(
  solution([
    ['yellow_hat', 'headgear'],
    ['blue_sunglasses', 'eyewear'],
    ['green_turban', 'headgear'],
  ])
); //5
// 2C0+2C1 = 3, 1C0+1C1 = 2 => 3*2-1

console.log(
  solution([
    ['crow_mask', 'face'],
    ['blue_sunglasses', 'face'],
    ['smoky_makeup', 'face'],
  ])
); // 3
// 3C0+3C1 = 4 => 4-1
