import sys
from itertools import combinations
input = sys.stdin.readline

N, L, R, X = map(int, input().split())
A = list(map(int, input().split()))
nums = [i for i in range(N)]
result = 0

for i in range(2, N+1):
    comb_list = combinations(nums, i)
    for combs in comb_list:
        level_sum = 0
        high = -1
        low = sys.maxsize
        for comb in combs:
            level_sum += A[comb]
            if A[comb] > high:
                high = A[comb]
            if A[comb] < low:
                low = A[comb]
        if L <= level_sum <= R and high - low >= X:
            result += 1

print(result)
