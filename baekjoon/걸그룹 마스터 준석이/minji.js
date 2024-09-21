const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 걸그룹 수, M: 문제 수
const girlGroup = new Map(); // 해시 알고리즘 사용을 위해 Map 이용

let index = 1;
let groupCnt = 1;
while (groupCnt <= N) {
  const groupName = input[index];
  const memberCnt = +input[index + 1];
  let members = [];

  for (let i = index + 2; i < index + 2 + memberCnt; i += 1) {
    members.push(input[i]); // 멤버 이름 넣기
  }
  girlGroup.set(groupName, members.sort()); // [그룹명, 멤버리스트] 향테러 Map에 넣기

  index += memberCnt + 2; // 다음 걸그룹 입력 값으로 이동
  groupCnt += 1; // 저장해야할 그룹 수 카운트
}

let answer = '';
for (let quiz = index; quiz < index + M * 2; quiz += 2) {
  const name = input[quiz];
  const number = +input[quiz + 1];

  // 퀴즈 0번
  if (number === 0) {
    // 해당 그룹 멤버들 answere에 넣기
    girlGroup.get(name).map((n) => (answer += n + '\n'));
  }
  // 퀴즈 1번
  else if (number === 1) {
    // 각 그룹에 해당 멤버 이름이 존재하는 경우 그룹 이름 answer에 넣기
    [...girlGroup.keys()].map((group) => {
      if (girlGroup.get(group).includes(name)) answer += group + '\n';
    });
  }
}

answer = answer.trimEnd();
console.log(answer);
