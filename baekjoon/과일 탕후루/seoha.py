import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
S = list(map(int, input().split()))

fruit = defaultdict(int)
start, end, cnt = 0, 0, 0

result = 0

while end < N:
    if fruit[S[end]] == 0:
        cnt += 1
    fruit[S[end]] += 1

    while cnt > 2:
        fruit[S[start]] -= 1
        if fruit[S[start]] == 0:
            cnt -= 1
        start += 1

    result = max(result, end - start + 1)
    end += 1

print(result)