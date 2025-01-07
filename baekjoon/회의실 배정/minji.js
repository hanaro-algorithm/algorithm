const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 회의의 수
const meetings = []; // 회의실 정보
for (let i = 1; i <= N; i += 1) meetings.push(input[i].split(' ').map(Number));

// 시작시간 기준 오름차순 정렬 || 끝나는 기준 오름차순 정렬
meetings.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

// 가능 회의 정보들
const possibleMeetings = [];
meetings.forEach((meeting) => {
  // 가능 회의 정보가 비어있거나 맨 위의 회의 끝나는 시간보다 현재 회의 시작시간이 크거나 같은 경우
  // 현재 회의 정보 넣기
  if (!possibleMeetings.length || possibleMeetings.at(-1)[1] <= meeting[0])
    possibleMeetings.push(meeting);
  else {
    // 맨 위 회의 끝나는 시간과 현재 회의 끝나는 시간 비교해서
    // 더 작은 값으로 회의 정보 변경해주기
    if (possibleMeetings.at(-1)[1] > meeting[1]) {
      possibleMeetings.pop();
      possibleMeetings.push(meeting);
    }
  }
});

console.log(possibleMeetings.length);
