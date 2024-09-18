import sys
from collections import deque

input = sys.stdin.readline

N, d, k, c = map(int, input().split())
food = [int(input()) for _ in range(N)]

result = 0
q = deque(food[:k])

for i in range(N):
    if i != 0:
        if i <= N/2:
            q.append(food[i+k-1])
        else:
            q.append(food[k-(N-i)-1])
    food_set = set(q)
    food_set.add(c)
    result = max(result, len(food_set))
    q.popleft()

print(result)