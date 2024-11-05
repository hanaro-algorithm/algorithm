import sys
from itertools import permutations

input = sys.stdin.readline
cnt = 0

n, k = map(int, input().split())
arr = list(map(int, input().split()))

for com in permutations([i for i in range(1,n+1)],n):
    kg = 500
    flag = True
    for c in com:
        kg += arr[c-1]
        kg -= k
        if kg < 500:
            flag = False
            break
    if flag:
        cnt += 1
print(cnt)