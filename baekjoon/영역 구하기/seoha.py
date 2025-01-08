import sys
from collections import deque
input = sys.stdin.readline

M, N, K = map(int, input().split())
graph = [[0 for _ in range(N)] for _ in range(M)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

result = []

def bfs(x, y):
    depth = 0
    q = deque([[x, y]])
    graph[x][y] = 1

    while q:
        x, y = q.popleft()

        depth += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if -1 < nx < M and -1 < ny < N:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = 1
                    q.append([nx, ny])

    return depth

for _ in range(K):
    a, b, c, d = map(int, input().split())
    for i in range(b, d):
        for j in range(a, c):
            graph[i][j] = 1

for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            result.append(bfs(i, j))

result.sort()
print(len(result))
print(*result)