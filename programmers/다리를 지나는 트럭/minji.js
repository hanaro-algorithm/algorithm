function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  let truckCnt = truck_weights.length; // 다리 길이

  let truckOnBridge = []; // 다리를 건너는 트럭
  let truckIndex = 0; // 대기하고 있는 트럭 중 가장 앞에 있는 트럭 인덱스
  let completeTruck = []; // 다리를 지난 트럭
  let bridgeCnt = 0; // 다리 위에 있는 트럭 수
  let bridgeTruckWeight = 0; // 다리 위에 있는 트럭들의 무게

  while (completeTruck.length < truckCnt) {
    time += 1; // 시간 증가
    truckOnBridge.map((truck) => {
      // 다리길이 만큼 지난 트럭은 completeTruck에 넣기
      if (time - truck[1] == bridge_length) {
        bridgeCnt -= 1;
        bridgeTruckWeight -= truck[0];
        let popTruck = truckOnBridge.shift();
        completeTruck.push(popTruck);
      }
    });
    if (
      bridgeCnt + 1 <= bridge_length &&
      bridgeTruckWeight + truck_weights[truckIndex] <= weight
    ) {
      let truck = truck_weights[truckIndex];
      truckOnBridge.push([truck, time]); // [트럭 무게, 다리에 진입한 시간]
      bridgeCnt += 1;
      bridgeTruckWeight += truck;
      truckIndex += 1;
    }
  }
  return time;
}

console.log(solution(2, 10, [7, 4, 5, 6])); // 8
console.log(solution(100, 100, [10])); // 101
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10])); // 110
