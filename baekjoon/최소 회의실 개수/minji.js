const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const meetings = [];
for (let i = 1; i <= N; i += 1) meetings.push(input[i].split(' ').map(Number));
meetings.sort((a, b) => a[0] - b[0]); // 시작 시간 기준 오름차순 정렬

const end = [meetings[0][1]]; // 첫 회의 정보 저장
let meetingRoomCnt = 1;

// 회의 종료 시간 배열 중 이어서 할 수 있는 회의실 있는지 확인
const checkMeetingRoom = (startTime) => {
  const idx = end.findIndex((e) => e <= startTime);
  return idx;
};

for (let meeting = 1; meeting < N; meeting += 1) {
  const findIdx = checkMeetingRoom(meetings[meeting][0]);
  // 만들어진 회의실을 그대로 사용할 수 없는 경우 회의실 새로 만들기
  if (findIdx === -1) {
    end.push(meetings[meeting][1]);
    meetingRoomCnt += 1;
  } else end[findIdx] = meetings[meeting][1]; // 기존 회의실의 종료시간 업데이트
}

console.log(meetingRoomCnt);
