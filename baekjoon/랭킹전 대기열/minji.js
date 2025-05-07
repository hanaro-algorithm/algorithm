/**
 * 문제) 랭킹전 대기열
 * 최종적으로 만들어진 방의 상태와 입장 플레이어 출력
 * - 플레이어 정보는 닉네임 사전 순으로 출력
 * - 방이 시작되었으면 Started!, 대기 중이면 Waiting! 출력
 *
 * 플레이어 간 방 매칭 조건에 맞춰 방 개설(구현)
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [p, m] = input[0].split(' ').map(Number); // p: 플레이어 수, m: 각 방의 정원

const gameRooms = {}; // 게임 방
const firstPlayers = []; // 각 게임 방의 처음 입장한 플레이어 레벨

let room = 0; // 방 번호
outer: for (let player = 1; player <= p; player++) {
  const [l, n] = input[player].split(' '); // l: 레벨, n: 닉네임

  for (let i = 0; i < firstPlayers.length; i++) {
    // 현재 플레이어의 레벨이 각 방의 첫번째 플레이어 레벨의 -10~+10 사이인 경우만
    // 각 방에 입장한 플레이어의 수가 m보다 작을 때만
    if (
      +l >= firstPlayers[i] - 10 &&
      +l <= firstPlayers[i] + 10 &&
      gameRooms[i].length < m
    ) {
      gameRooms[i] = [...gameRooms[i], { level: l, nickname: n }]; // 플레이어 추가
      continue outer; // 다음 플레이어로 이동
    }
  }
  // 들어갈 수 있는 방이 없는 경우, 새로운 게임 방 오픈
  gameRooms[room] = [{ level: l, nickname: n }];
  firstPlayers.push(+l);
  room++;
}

console.log(gameRooms);

let answer = '';
Object.keys(gameRooms).forEach((game) => {
  // 각 게임 방에 있는 플레이어를 닉네임 오름차순으로 정렬
  gameRooms[game].sort((a, b) => (a.nickname < b.nickname ? -1 : 1));
  // 각 게임 방에 인원이 다 찬 경우 Started! 출력, 아닌 경우 Waiting! 출력
  answer += gameRooms[game].length === m ? 'Started!\n' : 'Waiting!\n';
  // 각 게임 방의 플레이어 정보(레벨, 닉네임) 출력
  gameRooms[game].forEach(
    (player) => (answer += `${player.level} ${player.nickname}\n`)
  );
});
console.log(answer.trimEnd());
