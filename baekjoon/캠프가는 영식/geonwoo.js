const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, T] = input[0].trim().split(" ").map(Number);
let res = Number.MAX_SAFE_INTEGER;

for (let t = 1; t <= N; t++) {
  const [S, I, C] = input[t].trim().split(" ").map(Number);

  // 버스가 총 C대 있으므로 C대 모두 확인해본다.
  for (let i = 0; i < C; i++) {
    // 버스가 언제 도착하는지 계산한다.
    const time = S + I * i;

    // 영식이가 도착하는 시간보다 버스가 늦게오는 순간 그 차이를 계산하고 break한다.
    if (T <= time) {
      res = Math.min(res, time - T);
      break;
    }
  }
}

// 모든 버스를 확인했는데 MAX_SAFE_INTEGER라면 버스가 없는 경우이므로 -1을 출력한다.
if (res === Number.MAX_SAFE_INTEGER) console.log(-1);
else console.log(res);
