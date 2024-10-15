import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())

calendar = defaultdict(int)
result = 0

for _ in range(N):
    S, E = map(int, input().split())
    for i in range(S, E + 1):
        calendar[i] += 1

sorted_calendar = sorted(calendar.items())

pre = -1
w, h = 0, 0

for k, v in sorted_calendar:
    if k == pre + 1 or pre == -1:
        w += 1
        h = max(h, v)
    else:
        result += w * h
        w, h = 1, max(0, v)
    pre = k

result += w * h
print(result)
