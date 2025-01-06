import sys
input = sys.stdin.readline

graph = [list(map(int, input().split())) for _ in range(5)]

r, c = map(int, input().split())

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False for _ in range(5)] for _ in range(5)]

result = False

def dfs(depth, apple, x, y):
    global result
    if depth <= 3 and apple >=2:
        result = True
        return
    elif depth == 3:
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if -1 < nx < 5 and -1 < ny < 5:
            if not visited[nx][ny] and graph[nx][ny] != -1:
                if graph[nx][ny] == 1:
                    visited[nx][ny] = True
                    dfs(depth + 1, apple + 1, nx, ny)
                    visited[nx][ny] = False
                else:
                    visited[nx][ny] = True
                    dfs(depth + 1, apple, nx, ny)
                    visited[nx][ny] = False

visited[r][c] = True
if graph[r][c] == 1:
    dfs(0, 1, r, c)
else:
    dfs(0, 0, r, c)

if result:
    print(1)
else:
    print(0)

