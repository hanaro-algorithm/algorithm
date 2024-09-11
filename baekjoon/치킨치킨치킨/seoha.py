import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().rstrip().split())

arr = []
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().rstrip().split())))

M_list = [i for i in range(0, M)] # [0, 1, 2 ... M]

result = 0

for i in range(1, 4):
    comb = list(combinations(M_list, i)) # 치킨 종류가 i개일 때 모든 경우의 수
    for j in comb: # (0, 1, 2) : 예시
        sum = 0
        for k in range(N): # 모든 사람 탐색 (N명)
            k_max = 0
            for l in j: # 한 사람의 치킨 (0, 1, 2) 종류에 대해 가장 큰 만족도 탐색 : 예시
                if arr[k][l] > k_max:
                    k_max = arr[k][l]
            sum += k_max
        result = max(result, sum)

print(result)