const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 도시의 수(<=200)
const M = +input[1]; // 여행 계획에 속한 도시의 수(<=1000)

const arr = Array.from({ length: N + 1 }, (_, i) => i); // 초기화

const Find = (v) => {
  if (v === arr[v]) return v;
  else return (arr[v] = Find(arr[v]));
};

const Union = (x, y) => {
  const fx = Find(x);
  const fy = Find(y);
  if (fx !== fy) arr[fy] = fx;
};

// 연결되어 있는 도시들 합치기
for (let i = 2; i < 2 + N; i++) {
  const info = input[i].split(' ').map(Number);
  info.map((item, idx) => {
    if (item === 1) {
      Union(i - 1, idx + 1);
    }
  });
}

const plan = input[2 + N].split(' ').map(Number);
for (let p = 0; p < M - 1; p++) {
  const fa = Find(plan[p]);
  const fb = Find(plan[p + 1]);
  // 두 도시가 연결되어 있으면 다음 코스로 이동
  if (fa === fb) continue;
  // 연결되어 있지 않은 경우 여행 코스 방문 X
  else return console.log('NO');
}
console.log('YES');
