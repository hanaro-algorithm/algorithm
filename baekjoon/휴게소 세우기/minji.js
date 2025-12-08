const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// N: 현재 휴게소 개수, M: 추가로 지을 휴게소 개수, L: 고속도로 길이
const [N, M, L] = input[0].split(' ').map(Number);

// gap = [[휴게소 간의 간격, 시작위치, 끝위치]]
const gap = [];
let max = 0;

if (N === 0) {
    gap.push([L, 0, L]);
    max = L;
} else if (N !== 0) {
    const restArea = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b); // 현재 휴게소 위치 오름차순 정렬

    gap.push([restArea[0], 0, restArea[0]]);
    max = restArea[0]; // 최대간격 찾기
    for (let i = 1; i < N; i++) {
        gap.push([restArea[i] - restArea[i - 1], restArea[i - 1], restArea[i]]);
        max = Math.max(max, restArea[i] - restArea[i - 1]);
    }
    gap.push([L - restArea[N - 1], restArea[N - 1], L]);
    max = Math.max(max, L - restArea[N - 1]);
}

// 이분탐색 => 휴게소가 없는 구간의 최댓값의 최솟값으로 설정
let [start, end] = [1, max];

const addRestArea = (maxGap) => {
    let cnt = 0;
    for (const [g, first, last] of gap) {
        // 빈 휴게소 간격의 최댓값보다 큰 간격이 있을 경우 휴게소 세우기
        if (g > maxGap) {
            cnt += Math.floor((g - 1) / maxGap);
        }
    }
    return cnt;
};

let result = end;
while (start <= end) {
    const mid = parseInt((start + end) / 2);
    const cnt = addRestArea(mid); // mid를 최대로 만들기 위해 추가로 설치해야할 휴게소 개수
    // M개보다 작거나 같을 경우, 왼쪽 탐색 및 갱신
    if (cnt <= M) {
        result = mid;
        end = mid - 1;
    } else {
        start = mid + 1;
    }
}

console.log(result);
