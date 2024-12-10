const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0]; // 테스트케이스 개수
let line = 1;

let answer = '';
while (T > 0) {
  // n: 팀의 개수, k: 문제의 개수, t: 내 팀의 ID, m: 로그 엔트리 개수
  const [n, k, t, m] = input[line].split(' ').map(Number);
  const teamAnswer = Array.from({ length: n + 1 }, () => new Map()); // 각 팀 별 문제 당 최고 점수 저장
  const teamInfo = Array.from({ length: n + 1 }).map((_, idx) => [
    idx,
    0,
    0,
    0,
  ]); // 팀 번호, 최종점수, 로그 횟수, 최근 남긴 로그 시간

  for (let info = line + 1; info <= line + m; info += 1) {
    // i: 팀 ID, j: 문제 번호, s: 획득 점수
    const [i, j, s] = input[info].split(' ').map(Number);
    teamInfo[i][2] += 1; // 로그 횟수 추가
    teamInfo[i][3] = info; // 최근 남긴 로그 시간 업데이트
    // 각 팀의 각 문제의 점수 변경
    if (!teamAnswer[i].has(j))
      teamAnswer[i].set(j, s); // 처음 푼 문제인 경우
    else {
      if (teamAnswer[i].get(j) < s) teamAnswer[i].set(j, s); // 새로 푼 문제의 점수가 더 높을 경우 변경
    }
  }
  // 각 팀 별 최종 점수 넣기
  teamAnswer.forEach((team, index) =>
    team.forEach((score) => (teamInfo[index][1] += score))
  );

  // 최종 점수 기준으로 내림차순 정렬 || 최종 점수 같다면 로그 횟수 기준으로 오름차순 정렬(적은 기준) || 둘 다 같다면 로그 시간 오름차순 정렬(오래된 시간 기준)
  teamInfo
    .sort((a, b) => b[1] - a[1] || a[2] - b[2] || a[3] - b[3])
    .forEach((team, idx) => {
      if (team[0] === t) answer += idx + 1 + '\n';
    });

  line += m + 1;
  T -= 1;
}

answer = answer.trimEnd();
console.log(answer);
