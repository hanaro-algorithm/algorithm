def solution(bridge_length, weight, truck_weights):
    answer = 0
    in_bridge = list()
    total = 0
    while in_bridge or truck_weights:

        # 모든 트럭의 남은 거리 카운트
        deprecated = 0
        for idx, truck_info in enumerate(in_bridge):
            time, truck = truck_info
            if time == 1:  # 거리 1칸 남은 경우
                deprecated += 1
                total -= truck  # 트럭 제거
            else:
                in_bridge[idx][0] = time - 1  # 거리 감소
        del in_bridge[:deprecated]

        if truck_weights:
            result = total + truck_weights[0]  # 무게 합산
            if result <= weight and len(in_bridge) < bridge_length:
                in_bridge.append([bridge_length, truck_weights.pop(0)])  # 다리를 지난다.
                total = result

        answer += 1

    return answer