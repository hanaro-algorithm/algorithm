import sys
from collections import deque
input = sys.stdin.readline

dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]

n = int(input())
result = []
for _ in range(n):
    k = int(input())
    xs, ys = map(int, input().split())
    xe, ye = map(int, input().split())

    queue = deque()
    graph = [[-1] * k for _ in range(k)]
    queue.append((xs, ys))
    graph[xs][ys] = 0
    while queue:
        x, y = queue.popleft()
        for j in range(8):
            nx = x + dx[j]
            ny = y + dy[j]
            if nx < 0 or nx >= k or ny < 0 or ny >= k:
                continue
            if graph[nx][ny] != -1:
                continue
            graph[nx][ny] = graph[x][y] + 1
            queue.append((nx, ny))
        if graph[xe][ye] != -1:
            break
    result.append(graph[xe][ye])

for r in result:
    print(r)