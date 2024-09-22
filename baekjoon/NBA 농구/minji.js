const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 골이 들어간 횟수
let scores = [];
for (let i = 1; i <= N; i += 1) {
  let [team, time] = input[i].split(' ');
  time = time.split(':'); // 골 넣은 시간 초로 변경하기 위해 : 없애기
  scores.push([+team, +time[0] * 60 + +time[1]]);
}

const lastTime = 48 * 60; // 경기 시간 초 단위로 변경

let teamScore = [0, 0]; // 각 팀의 골 넣은 횟수
let teamTime = [0, 0]; // 각 팀 이기고 있는 시간 카운트

let index = 0;
let [team, time] = scores[index]; // 골 넣은 리스트에서 팀 번호와 시간 추출

// 0초부터 경기시간(48분)까지 타이머 동작
for (let timer = 0; timer < lastTime; timer += 1) {
  // 골 넣은 시간이 되었을 때
  if (time === timer) {
    teamScore[team - 1] += 1; // 해당 팀 골 넣은 횟수 카운트
    if (index < N - 1) [team, time] = scores[++index]; // 다음 골 넣은 팀으로 이동(단, 마지막 팀인 경우는 제외)
  }

  // 1팀이 이기고 있는 경우 1팀 이기고 있는 시간 카운트
  if (teamScore[0] > teamScore[1]) teamTime[0] += 1;
  // 2팀이 이기고 있는 경우 2팀 이기고 있는 시간 카운트
  else if (teamScore[0] < teamScore[1]) teamTime[1] += 1;
}

let answer = '';
teamTime.map((team) => {
  let minutes = parseInt(team / 60) + ''; // 다시 분으로 변경
  let seconds = (team % 60) + '';

  // 00:00 형태로 맞추기 위해 padStart 이용해서 두자리 수로 만들기
  answer += `${minutes.padStart(2, 0)}:${seconds.padStart(2, 0)}\n`;
});

answer = answer.trimEnd();
console.log(answer);
