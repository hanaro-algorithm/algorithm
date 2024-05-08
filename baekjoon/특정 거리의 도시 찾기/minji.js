const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// N: 도시의 개수, M: 도로의 개수, K: 거리 정보, X: 출발 도시 번호
const [N, M, K, X] = input[0].split(" ").map(Number);
let cities = Array.from({ length: N + 1 }, () => []);
for (let i = 1; i <= M; i += 1) {
    const [A, B] = input[i].split(" ").map(Number);
    cities[A].push(B);
}
let shortDepth = new Array(N + 1).fill(0);

let queue = [];
queue.push([X, 0]); // [도시 번호, 거리]

while (queue.length > 0) {
    let [city, depth] = queue.shift();
    if (shortDepth[city] === 0 || shortDepth[city] > depth)
        shortDepth[city] = depth;
    for (let c of cities[city]) {
        queue.push([c, depth + 1]);
    }
}

let found = false;
shortDepth.map((d, idx) => {
    if (d === K) {
        found = true;
        console.log(idx);
    }
});

if (!found) console.log(-1);
