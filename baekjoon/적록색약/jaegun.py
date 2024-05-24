from collections import deque

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(str, input())))

visited = [[False] * n for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, color, visited, graph):
    n = len(graph)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] == color:
                visited[nx][ny] = True
                queue.append((nx, ny))

n = len(graph)
normal_visited = [[False] * n for _ in range(n)]
color_weak_visited = [[False] * n for _ in range(n)]
normal_count = 0
color_weak_count = 0

# 적록색약 아닌 사람
for i in range(n):
    for j in range(n):
        if not normal_visited[i][j]:
            bfs(i, j, graph[i][j], normal_visited, graph)
            normal_count += 1

# 적록색약인 사람을 위해 G를 R로 간주
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

# 적록색약인 사람
for i in range(n):
    for j in range(n):
        if not color_weak_visited[i][j]:
            bfs(i, j, graph[i][j], color_weak_visited, graph)
            color_weak_count += 1

print(normal_count, color_weak_count)
