from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    currWeight = 0
    bridge=deque([0]*bridge_length)
    while bridge:
        answer+=1
        currWeight -= bridge.popleft()
        if len(truck_weights)!=0:
            if currWeight+truck_weights[0] <= weight:
                a=truck_weights.pop(0)
                bridge.append(a)
                currWeight+=a
            else:
                bridge.append(0)
    return answer

res=solution(2,10, [7,4,5,6])
print(res)