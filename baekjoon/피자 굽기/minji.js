/**
 * 문제) 피자 굽기
 * 맨 위의 피자가 들어갈 오븐 위치(최상단이 1)
 *
 * ✰ 밑에 오븐보다 위에 있는 오븐의 크기가 더 작은 경우, 더 작은 오븐 크기에 맞춰줘야함! (어차피 막혀서 못내려감)
 * 1) 오븐 크기를 지름에 맞추기
 * 2) 밑에서부터 피자를 넣을 수 있는 오븐 위치 찾기
 * 3) 위치 찾으면 현재 오븐에 피자 넣고 다음 오븐부터 탐색
 * 4) 피자를 넣을 수 있는 오븐이 없으면 바로 0 리턴
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [D, N] = input[0].split(' ').map(Number); // 오븐 깊이 D, 피자 반죽 개수 N
const ovens_radius = input[1].split(' ').map(Number); // 각 오븐 높이 반지름

// 이전 오븐이 더 크기가 작은 경우 해당 크기게 맞추기(어차피 밑으로 못들어감)
for (let oven = 1; oven < D; oven++) ovens_radius[oven] = Math.min(ovens_radius[oven], ovens_radius[oven - 1]);

const pizza_radius = input[2].split(' ').map(Number); // 피자 반지름

let current_floor = D - 1; // 현재 피자를 넣을 수 있는 오븐의 높이(밑에서부터)
let result = 0;

for (let pizza = 0; pizza < N; pizza += 1) {
    let input_floor = -1;
    for (let floor = current_floor; floor > 0; floor -= 1) {
        // 피자 지름이 오븐에 들어갈 때 해당 오븐에 넣기
        if (pizza_radius[pizza] * 2 <= ovens_radius[floor] * 2) {
            input_floor = floor; // 현재 오븐에 피자 넣기
            current_floor = floor - 1; // 다음 오븐부터 탐색하도록 1 증가
            break;
        }
    }
    // 어떤 오븐에도 피자가 들어가지 않는 경우
    if (input_floor === -1) {
        console.log(0);
        return;
    }
    result = input_floor;
}

console.log(result + 1);
