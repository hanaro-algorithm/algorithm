import sys
sys.setrecursionlimit(10000)

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

N = int(input())
graph = [list(map(int, input().rstrip().split())) for _ in range(N)]

max_height = max(map(max, graph))
result = 1

def dfs(x, y, height, visited):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if -1 < nx < N and -1 < ny < N:
            if graph[nx][ny] > height and visited[nx][ny] == False:
                dfs(nx, ny, height, visited)

for height in range(1, max_height):
    visited = [[False] * N for _ in range(N)]
    temp = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j] > height and visited[i][j] == False:
                dfs(i, j, height, visited)
                temp += 1
    result = max(result, temp)
print(result)