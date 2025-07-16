const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;
let answer = '';

const Find = (x, parentNode) => {
  if (x === parentNode[x]) return x;
  else return (parentNode[x] = Find(parentNode[x], parentNode));
};

while (true) {
  const [m, n] = input[line++].split(' ').map(Number); // m: 집의 수, n: 길의 수
  if (m === 0 && n === 0) break; // 입력 끝인 경우 테스트케이스 종료

  let totalCost = 0; // 도시의 기존 전력 비용
  const parentNode = Array.from({ length: m }, (_, idx) => idx); // 부모 정점 배열(초기에는 본인 정점 넣기)
  const city = []; // 연결되어 있는 도시 정보
  for (let i = 0; i < n; i++) {
    const [x, y, z] = input[line++].split(' ').map(Number); // x번 집과 y번 집 사이 거리가 z미터
    totalCost += z;
    city.push({ cost: z, node: [x, y] });
  }
  city.sort((a, b) => a.cost - b.cost || a.node[0] - b.node[0]); // 연결되어 있는 도시 정보 가중치(거리) 기준 오름차순 정렬

  let selectCost = 0; // 선택된 거리의 비용
  let selectCnt = 0; // 선택된 거리 개수
  for (const c of city) {
    const a = Find(c.node[0], parentNode);
    const b = Find(c.node[1], parentNode);
    if (a === b) continue; // 사이클 생성됨 -> 해당 길 선택 X

    // 두 집 길 연결 시키기
    parentNode[b] = a;
    selectCost += c.cost;
    selectCnt++;

    if (selectCnt === m - 1) break; // 선택된 간선의 수가 m-1이면 종료
  }
  answer += totalCost - selectCost + '\n';
}

console.log(answer.trimEnd());
