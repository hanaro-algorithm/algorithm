const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사진틀의 개수
const totalRecommendCnt = +input[1]; // 전체 학생의 총 추천 횟수
const recommendList = input[2].split(' ').map(Number); // 추천받은 학생들

const pictures = new Map(); // 사진틀
recommendList.forEach((recommend, idx) => {
  // 이미 존재하는 후보인 경우
  if (pictures.has(recommend)) {
    const [cnt, time] = pictures.get(recommend);
    pictures.set(recommend, [cnt + 1, time]); // 추천 수 + 1
  } else if (pictures.size < N)
    pictures.set(recommend, [1, idx]); // 사진틀이 남아있고, 새로운 후보인 경우
  else {
    // 추천수 오름차순 정렬 || 같다면 시간 기준 오름차순 정렬 후 가장 맨 앞에 오는 값 Map에서 삭제
    const target = [...pictures.entries()].sort(
      (a, b) => a[1][0] - b[1][0] || a[1][1] - b[1][1]
    )[0];
    pictures.delete(target[0]);
    pictures.set(recommend, [1, idx]); // 새로운 후보 등록
  }
});

console.log(...[...pictures.keys()].sort((a, b) => a - b)); // 후보 번호 기준 오름차순 정렬 후 최종 후보 출력
