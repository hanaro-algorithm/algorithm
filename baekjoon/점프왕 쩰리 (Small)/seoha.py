import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

q = deque([[0, 0]])

while q:
    x, y = q.popleft()
    step = graph[x][y]

    if step == -1:
        print('HaruHaru')
        exit()
    if step == 0:
        continue
    if x + step < N:
        q.append([x+step, y])
    if y + step < N:
        q.append([x, y+step])

print('Hing')