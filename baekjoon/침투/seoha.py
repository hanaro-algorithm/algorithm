import sys
from collections import deque

sys.setrecursionlimit(3000000)

input = sys.stdin.readline

N, M = map(int, input().split())

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

graph = [list(map(int, input().rstrip())) for _ in range(N)]

def bfs(x, y):
    q = deque()
    q.append([x, y])

    while q:
        x, y = q.popleft()
        if x == N-1:
            print('YES')
            exit()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = 1
                    q.append([nx, ny])

for i in range(M):
    if graph[0][i] == 0:
        bfs(0, i)
print('NO')