/**
 * 새로 추가된 점수의 랭킹 구하기
 * 
 * - 비오름차순? → 내림차순 의미? 정렬x 의미?
 * 
 * 이분탐색 이용
 * 1. 만약 비오름차순이 정렬이 안된걸 의미하면, 점수를 내림차순 정렬
 * 2. 추가된 점수가 들어갈 인덱스 찾기 → 이분탐색 시작
 *      N=0인 경우 이분탐색 시작 x
 *      시작=0, 끝=N, 중간 인덱스 찾기
 *      중간 인덱스에 있는 값 ≥ 추가된 점수, 오른쪽 탐색(시작=mid+1) → 최종 위치 갱신(mid+1)    
 *      중간 인덱스에 있는 값 < 추가된 점수, 왼쪽 탐색(끝=mid+1)
 * 3. 최종 위치가 P보다 크거나 같을 경우(0인덱스부터시작) -1 리턴
 * 4. 아닌 경우 자신과 같은 수 카운트 → 현재인덱스-같은 수 개수+1 리턴
 */
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// 리스트에 있는 점수 개수 N, 점수 랭킹에 존재할 수 있는 점수의 개수 P
const [N, newScore, P] = input[0].split(" ").map(Number);
if (N === 0) return console.log(1); // 현재 랭킹 리스트에 아무것도 없을 때 1등 출력(10<=P<=50)

const ranking = input[1].split(" ").map(Number); // 현재 랭킹 리스트에 있는 점수 정보

ranking.sort((a, b) => b - a); // 현재 랭킹 리스트 점수를 내림차순으로 정렬

let start = 0;
let end = N;

while (start <= end) {
  const mid = parseInt((start + end) / 2);

  // 중간 인덱스에 있는 점수가 새 점수보다 크거나 같은 경우 오른쪽 탐색
  if (ranking[mid] >= newScore) start = mid + 1;
  else end = mid - 1; // 작은 경우 왼쪽 탐색
}

if (start >= P) return console.log(-1); // 랭킹 리스트에 들지 못할 경우 -1 출력

const sameScoreCnt = ranking.filter((score) => score === newScore).length; // 같은 점수가 몇 개인지 카운트
console.log(start - sameScoreCnt + 1); // 같은 점수(동등 랭킹) 고려해서 랭킹 출력
