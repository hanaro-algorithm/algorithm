/**
 * 모든 파티에 참석할 때, 거짓말 쟁이가 되지 않는 선에서 과장된 이야기를 할 수 있는 파티의 개수 출력
 *
 * 유니온 파인드 이용
 * 진실을 아는 사람을 기준으로 같은 파티에 참석하는 사람 확인
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const [N, M] = input[0].split(' ').map(Number); // 사람 수, 파티 수

const parent = Array.from({ length: N + 1 }, (_, i) => i); // 같은 영역에 존재하는지 확인하기 위한 배열

const find = (v) => {
    if (parent[v] === v) return v;
    return (parent[v] = find(parent[v]));
};

const union = (x, y) => {
    const fx = find(x);
    const fy = find(y);
    if (fx < fy) parent[fy] = fx;
    else parent[fx] = fy;
};

const party = Array.from({ length: M }, () => []);
const [K, ...know] = input[1].split(' ').map(Number);
for (let k = 0; k < K; k++) union(0, know[k]); // 진실을 아는 사람은 부모를 0으로 전파

for (let p = 0; p < M; p++) {
    const [num, ...people] = input[p + 2].split(' ').map(Number);
    party[p].push(...people); // 각 파티에 참석하는 사람들 배열에 넣기
    for (let i = 0; i < num - 1; i++) {
        union(people[i], people[i + 1]); // 같은 영역으로 만들기
    }
}

let answer = 0;
for (const attendee of party) {
    // 진실을 아는 사람이 존재하면 다음 파티 확인 => 해당 파티는 진실만 말해야함
    if (find(attendee[0]) === 0) continue;
    answer += 1;
}
console.log(answer);
